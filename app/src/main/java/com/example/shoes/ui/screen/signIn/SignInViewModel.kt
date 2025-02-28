package com.example.shoes.ui.screen.signIn

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SignInViewModel : ViewModel() {
    var signInState = mutableStateOf(SignInState())
        private set

    val emailHasError = derivedStateOf {
        if(signInState.value.email.isEmpty()) return@derivedStateOf false
        !android.util.Patterns.EMAIL_ADDRESS.matcher(signInState.value.email).matches()
    }

    val passwordHasError = derivedStateOf {
        val passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,}$".toRegex()
        if(signInState.value.password.isEmpty()) return@derivedStateOf false
        !passwordPattern.matches(signInState.value.password)
    }

    fun setEmail(email: String) {
        signInState.value = signInState.value.copy(email = email)
    }

    fun setPassword(password: String) {
        signInState.value = signInState.value.copy(password = password)
    }
}