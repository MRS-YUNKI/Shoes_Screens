package com.example.shoes.ui.screen.verification

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.shoes.R
import com.example.shoes.ui.theme.ShoesColors
import com.example.shoes.ui.theme.ShoesTheme
import com.example.shoes.ui.theme.ShoesTheme.colors
import kotlinx.coroutines.delay

@Composable
fun VerificationScreen(
    onBackClick: () -> Unit = {},
    onVerifySuccess: () -> Unit = {}
) {
    val otpLength = 6
    val otpValues = remember { mutableStateListOf(*Array(otpLength) { "" }) }
    val focusRequesters = remember { List(otpLength) { FocusRequester() } }
    val focusManager = LocalFocusManager.current
    var focusedIndex by remember { mutableStateOf(0) }

    var remainingTime by remember { mutableIntStateOf(60) }
    var isTimerActive by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        while (remainingTime > 0 && isTimerActive) {
            delay(1000L)
            remainingTime--
        }
    }

    fun formatTime(seconds: Int): String {
        val minutes = seconds / 60
        val remainingSeconds = seconds % 60
        return String.format("%d:%02d", minutes, remainingSeconds)
    }

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .padding(top = 10.dp, start = 16.dp)
                    .fillMaxWidth()
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        painter = painterResource(id = R.drawable.back_arrow),
                        contentDescription = "Назад"
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 24.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.otp_title),
                style = ShoesTheme.typography.headingBold30,
                modifier = Modifier.padding(top = 124.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.otp_text),
                style = ShoesTheme.typography.bodyRegular16,
                textAlign = TextAlign.Center,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(32.dp))

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "OTP Код",
                    style = ShoesTheme.typography.bodyRegular16,
                    modifier = Modifier.padding(top = 16.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    for (i in 0 until otpLength) {
                        val isFocused = i == focusedIndex
                        val borderColor = when {
                            isFocused -> Color(0xFF00A4FF)
                            else -> Color.White
                        }

                        Box(
                            modifier = Modifier
                                .width(46.dp)
                                .height(99.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .border(
                                    width = 1.dp,
                                    color = borderColor,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .background(Color(0xFFF7F7F9))
                                .onFocusChanged { focusState ->
                                    if (focusState.isFocused) {
                                        focusedIndex = i
                                    }
                                }
                                .focusRequester(focusRequesters[i])
                        ) {
                            BasicTextField(
                                value = otpValues[i],
                                onValueChange = { value ->
                                    if (value.length <= 1) {
                                        otpValues[i] = value
                                        if (value.isNotEmpty()) {
                                            if (i < otpLength - 1) {
                                                focusRequesters[i + 1].requestFocus()
                                            } else {
                                                focusManager.clearFocus()
                                            }
                                        }
                                    }
                                },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                textStyle = ShoesTheme.typography.headingBold30.copy(
                                    color = ShoesTheme.colors.text,
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(Alignment.Center)
                            )
                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Отправить код повторно",
                        style = ShoesTheme.typography.bodyRegular16.copy(
                            color = if (remainingTime == 0) ShoesTheme.colors.subTextDark else ShoesTheme.colors.subTextLight
                        ),
                        modifier = Modifier
                            .clickable(
                                enabled = remainingTime == 0,
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null
                            ) {
                                if (remainingTime == 0) {
                                    remainingTime = 60
                                    isTimerActive = true
                                }
                            }
                    )

                    Text(
                        text = formatTime(remainingTime),
                        style = ShoesTheme.typography.bodyRegular16.copy(
                            color =  ShoesTheme.colors.subTextDark
                        )
                    )
                }
            }
        }
    }
}