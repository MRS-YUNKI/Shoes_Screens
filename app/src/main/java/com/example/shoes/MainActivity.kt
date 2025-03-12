package com.example.shoes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.shoes.ui.screen.forgotPassword.ForgotPasswordScreen
import com.example.shoes.ui.screen.signIn.SignInScreen
import com.example.shoes.ui.screen.signUp.SignUpScreen
import com.example.shoes.ui.theme.ShoesTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoesTheme {
                SignUpScreen()
            }
        }
    }
}