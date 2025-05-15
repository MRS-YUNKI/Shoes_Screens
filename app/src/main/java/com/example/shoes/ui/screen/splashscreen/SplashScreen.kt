package com.example.shoes.ui.screen.splashscreen

import android.window.SplashScreen
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
import com.example.shoes.data.Auth
import com.example.shoes.data.domain.usecase.AuthUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

@Composable
fun SplashScreen(
    authUseCase: AuthUseCase,
    onNavigationToProfile: () -> Unit,
    onNavigationToSignUpScreen: () -> Unit){
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
        verticalArrangement = Arrangement.Center
    )  {
        Image(
            painter = painterResource(R.drawable.matule_me),
            contentDescription =  null
        )
        LaunchedEffect(Unit) {
            authUseCase.token.collect {
                if (it != "") {
                    onNavigationToProfile
                    return@collect
                }
                onNavigationToSignUpScreen
            }
        }
    }
}