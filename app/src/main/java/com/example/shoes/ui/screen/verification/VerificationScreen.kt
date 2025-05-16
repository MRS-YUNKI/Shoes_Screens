package com.example.shoes.ui.screen.verification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.shoes.R
import com.example.shoes.ui.theme.ShoesTheme

@Composable
fun VerificationScreen(onBackClick: () -> Unit = {}) {
    val otpLength = 6
    val otpValues = remember { mutableStateListOf(*Array(otpLength) { "" }) }
    val focusRequesters = remember { List(otpLength) { FocusRequester() } }
    val focusManager = LocalFocusManager.current
    var focusedIndex by remember { mutableStateOf(0) }

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
                text = "OTP Проверка",
                style = ShoesTheme.typography.headingBold30,
                modifier = Modifier.padding(top = 124.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Пожалуйста, проверьте свою\nэлектронную почту, чтобы увидеть код подтверждения",
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
                            isFocused -> Color(0xFF00A4FF) // Голубой
                            else -> Color.White
                        }

                        Box(
                            modifier = Modifier
                                .width(46.dp)
                                .height(99.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFFF2F2F2))
                                .border(2.dp, borderColor, RoundedCornerShape(12.dp))
                                .focusRequester(focusRequesters[i])
                                .onFocusChanged { focusState ->
                                    if (focusState.isFocused) {
                                        focusedIndex = i
                                    }
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            BasicTextField(
                                value = otpValues[i],
                                onValueChange = {
                                    if (it.length <= 1 && it.all { char -> char.isDigit() }) {
                                        otpValues[i] = it
                                        if (it.isNotEmpty() && i < otpLength - 1) {focusRequesters[i + 1].requestFocus()
                                        }
                                    }
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentSize(Alignment.Center),
                                textStyle = ShoesTheme.typography.headingBold30.copy(
                                    color = Color.Black,
                                    textAlign = TextAlign.Center
                                ),
                                singleLine = true,
                                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                                decorationBox = { innerTextField ->
                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        if (otpValues[i].isEmpty()) {
                                            Text(
                                                text = "0",
                                                style = ShoesTheme.typography.headingBold30,
                                                color = Color.Gray
                                            )
                                        }
                                        innerTextField()
                                    }
                                }
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Отправить заново", color = Color.Gray)
                Text(text = "00:30", color = Color.Gray)
            }
        }
    }
}