package com.example.shoes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.internal.composableLambda
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shoes.ui.screen.signIn.SignInScreen
import com.example.shoes.ui.screen.signUp.SignUpScreen
import com.example.shoes.ui.screen.splashscreen.SplashScreen
import com.example.shoes.ui.theme.ShoesTheme
import kotlinx.serialization.Serializable


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            ShoesTheme {
                NavHost(navController, startDestination = SplashScreen) {
                    composable<SplashScreen> {
                        SplashScreen() {
                            navController.navigate(route = Registration)
                        }
                    }
                    composable<Registration> {
                        SignUpScreen() {
                            navController.navigate(route = Profile)
                        }
                    }
                    composable<Profile> {
                        SignInScreen()
                    }
                }
            }
        }
    }
}

@Serializable
object SplashScreen
@Serializable
object Registration
@Serializable
object Profile