package com.example.shoes.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.shoes.R
import com.example.shoes.data.domain.usecase.AuthUseCase
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    authUseCase: AuthUseCase,
    onNavigationToSignInScreen: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF48B2E7),
                        Color(0xFF0076B1)
                    )
                )
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.matule_me),
            contentDescription = null
        )

        LaunchedEffect(Unit) {
            delay(2000)
            onNavigationToSignInScreen()
        }
    }
}