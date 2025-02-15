package com.example.shoes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.shoes.ui.screen.ForgotPasswordCommonButton
import com.example.shoes.ui.screen.ForgotPasswordScreen
import com.example.shoes.ui.screen.SignInScreen
import com.example.shoes.ui.screen.SignUpScreen
import com.example.shoes.ui.theme.ShoesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoesTheme {
                SignInScreen()
                //SignUpScreen()
                //ForgotPasswordScreen()
            }
        }
    }
}