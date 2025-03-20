package com.example.shoes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.internal.composableLambda
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shoes.data.RetrofitClient
import com.example.shoes.data.domain.usecase.AuthUseCase
import com.example.shoes.data.local.datastore.LocalDataStore
import com.example.shoes.data.local.localStorage
import com.example.shoes.data.repository.AuthRepository
import com.example.shoes.ui.screen.signIn.SignInScreen
import com.example.shoes.ui.screen.signUp.SignUpScreen
import com.example.shoes.ui.screen.splashscreen.SplashScreen
import com.example.shoes.ui.theme.ShoesTheme
import kotlinx.serialization.Serializable


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val localStorage = localStorage(applicationContext)
        val authRepository = AuthRepository(RetrofitClient.retrofit)
        val authUseCase = AuthUseCase(localStorage, authRepository)
        setContent {
            val navController = rememberNavController()
            ShoesTheme {
                NavHost(navController, startDestination = SplashScreen) {
                    composable<SplashScreen> {
                        SplashScreen(
                            authUseCase = authUseCase,
                            onNavigationToProfile = {
                                navController.navigate(route = Profile)
                            }
                        ) {
                            navController.navigate(route = Registration)
                        }
                    }
                    composable<Registration> {
                        SignUpScreen(authUseCase) {
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