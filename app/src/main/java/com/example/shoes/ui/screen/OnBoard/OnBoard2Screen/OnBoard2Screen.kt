package com.example.shoes.ui.screen.OnBoard.OnBoard2Screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.shoes.R
import com.example.shoes.ui.screen.OnBoard.OnBoard1Screen.component.OnboardingIndicatorSvg
import com.example.shoes.ui.screen.OnBoard.component.OnBoardButton
import com.example.shoes.ui.theme.ShoesTheme

@Composable
fun OnBoardTwoScreen(
    onNext: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF48B2E7),
                        Color(0xFF0076B1)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))

            Image(
                painter = painterResource(R.drawable.image_2),
                contentDescription = null,
                modifier = Modifier.size(width = 375.dp, height = 302.dp)
            )

            Spacer(modifier = Modifier.height(60.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(R.string.on_board2_start1),
                    style = ShoesTheme.typography.headingBold32.copy(color = Color.White),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 20.dp)
                )
                Text(
                    text = stringResource(R.string.on_board2_start2),
                    style = ShoesTheme.typography.bodyRegular16.copy(color = Color.White),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 12.dp)
                )

                OnboardingIndicatorSvg(
                    totalDots = 3,
                    selectedIndex = 1,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
        OnBoardButton(
            onClick = onNext,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp)
        ) {
            Text(
                text = stringResource(R.string.on_board2_next),
                style = ShoesTheme.typography.bodyRegular16.copy(color = Color.Black),
                textAlign = TextAlign.Center
            )
        }
    }
}