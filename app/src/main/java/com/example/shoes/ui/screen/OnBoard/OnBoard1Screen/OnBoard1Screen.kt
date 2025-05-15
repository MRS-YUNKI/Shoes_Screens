package com.example.shoes.ui.screen.OnBoard.OnBoard1Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shoes.R
import com.example.shoes.data.domain.usecase.AuthUseCase
import com.example.shoes.ui.screen.OnBoard.OnBoard1Screen.component.OnboardingIndicatorSvg
import com.example.shoes.ui.screen.OnBoard.component.OnBoardButton
import com.example.shoes.ui.screen.signIn.component.TitleWithSubtitleText
import com.example.shoes.ui.theme.ShoesTheme

@Composable
fun OnBoardOneScreen(
    onNext: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF48B2E7),
                        Color(0xFF0076B1)
                    )
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(R.string.on_board1_welcome),
                style = ShoesTheme.typography.headingBold30.copy(color = Color.White),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 65.dp)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 130.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.image_1),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 375.dp, height = 302.dp)
                        .align(Alignment.CenterEnd)
                )
            }

            OnboardingIndicatorSvg(
                totalDots = 3,
                selectedIndex = 0,
                modifier = Modifier.padding(top = 16.dp)
            )
        }

        Column(
            modifier = Modifier.padding(bottom = 32.dp)
        ) {
            OnBoardButton(
                onClick = onNext
            ) {
                Text(stringResource(R.string.on_board1_start))
            }
        }
    }
}