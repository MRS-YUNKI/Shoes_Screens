package com.example.shoes.ui.screen.splashscreen

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.shoes.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

@Composable
fun SplashScreen(onNavigationToSignUpScreen: () -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )  {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription =  null
        )
        runBlocking {
            delay(3000)
            onNavigationToSignUpScreen()
        }
    }
}