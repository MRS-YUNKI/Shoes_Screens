package com.example.shoes.ui.screen.OnBoard.OnBoard1Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.example.shoes.ui.screen.OnBoard.OnBoard1Screen.component.OnBoard1Button
import com.example.shoes.ui.screen.signIn.component.TitleWithSubtitleText
import com.example.shoes.ui.theme.ShoesTheme

@Composable
fun OnBoardOneScreen(
//    authUseCase: AuthUseCase,
//    onNavigationToOnBoardTwoScreen: () -> Unit,
//    onNavigationToOnBoardThreeScreen: () -> Unit,
) {
    Column (
        modifier = Modifier
        .fillMaxSize()
        .background(
            Brush.verticalGradient(
                colors = listOf(
                    Color(0xFF48B2E7),
                    Color(0xFF0076B1)
                )
            ),
    ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

    }

    Column (modifier = Modifier
        .padding(top = 70.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.on_board1_welcome),
            style = ShoesTheme.typography.headingBold30.copy(color = ShoesTheme.colors.block),
            textAlign = TextAlign.Center
        )
        Column (
            modifier = Modifier
                .padding(bottom = 36.dp)
        ){
            OnBoard1Button(
                onClick = {}
            ) {
                Text(stringResource(R.string.on_board1_start))
            }
        }

    }
}