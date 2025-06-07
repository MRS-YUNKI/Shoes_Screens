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
import com.example.shoes.ui.screen.OnBoard.OnBoard1Screen.OnBoardOneScreen
import com.example.shoes.ui.screen.OnBoard.OnBoard2Screen.OnBoardThreeScreen
import com.example.shoes.ui.screen.OnBoard.OnBoard2Screen.OnBoardTwoScreen
import com.example.shoes.ui.screen.home.HomeScreen
import com.example.shoes.ui.screen.signIn.SignInScreen
import com.example.shoes.ui.screen.signUp.SignUpScreen
import com.example.shoes.ui.screen.splashscreen.SplashScreen
import com.example.shoes.ui.theme.ShoesTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        val localStorage = localStorage(applicationContext)
//        val authRepository = AuthRepository(RetrofitClient.retrofit)
//        val authUseCase = AuthUseCase(localStorage, authRepository)

        setContent {
            ShoesTheme {
                HomeScreen()

//                val navController = rememberNavController()
//
//                NavHost(
//                    navController = navController,
//                    startDestination = "splash"
//                ) {
//                    composable("splash") {
//                        SplashScreen(
//                            authUseCase = authUseCase,
//                            onNavigationToSignInScreen = {
//                                navController.navigate("signIn") {
//                                    popUpTo("splash") { inclusive = true }
//                                }
//                            }
//                        )
//                    }
//
//                    composable("signIn") {
//                        SignInScreen(
//                            authUseCase = authUseCase,
//                            onNavigateToSignUp = {
//                                navController.navigate("signUp") {
//                                    launchSingleTop = true
//                                }
//                            },
//                            onSignInSuccess = {
//                                navController.navigate("onBoard1") {
//                                    popUpTo("signIn") { inclusive = true }
//                                }
//                            }
//                        )
//                    }
//
//                    composable("signUp") {
//                        SignUpScreen(
//                            onNavigateToSignIn = {
//                                navController.navigate("signIn") {
//                                    popUpTo("signUp") { inclusive = true }
//                                }
//                            }
//                        )
//                    }
//
//                    composable("onBoard1") {
//                        OnBoardOneScreen(
//                            onNext = {
//                                navController.navigate("onBoard2")
//                            }
//                        )
//                    }
//
//                    composable("onBoard2") {
//                        OnBoardTwoScreen(
//                            onNext = {
//                                navController.navigate("onBoard3")
//                            }
//                        )
//                    }
//
//                    composable("onBoard3") {
//                        OnBoardThreeScreen()
//                    }
//                }
            }
        }
    }
}