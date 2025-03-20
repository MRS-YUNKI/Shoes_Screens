package com.example.shoes.ui.screen.signUp

import android.util.Patterns
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoes.ui.screen.signIn.SignInState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {
    var signUpState = mutableStateOf(SignUpState())
        private set

    val emailHasError = derivedStateOf {
        if(signUpState.value.email.isEmpty()) return@derivedStateOf false
        !Patterns.EMAIL_ADDRESS.matcher(signUpState.value.email).matches()
    }

    val passwordHasError = derivedStateOf {
        val passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,}$".toRegex()
        if(signUpState.value.password.isEmpty()) return@derivedStateOf false
        !passwordPattern.matches(signUpState.value.password)
    }

    val nameHasError = derivedStateOf {
        val namePattern = "^[A-ZА-ЯЁ][a-zа-яё]{1,49}$".toRegex()
        if(signUpState.value.name.isEmpty()) return@derivedStateOf false
        !namePattern.matches(signUpState.value.name)
    }

    fun setName(name: String) {
        signUpState.value = signUpState.value.copy(name = name)
    }

    fun setEmail(email: String) {
        signUpState.value = signUpState.value.copy(email = email)
    }

    fun setPassword(password: String) {
        signUpState.value = signUpState.value.copy(password = password)
    }

    fun togglePasswordVisibility() {
        signUpState.value = signUpState.value.copy(isVisiblePassword = !signUpState.value.isVisiblePassword)
    }

    fun registration() {
        viewModelScope.launch {
            delay(2000)
            signUpState.value = signUpState
                .value
                .copy(isSignUp =  true)
        }
    }
}