package com.example.shoes.ui.screen.forgotPassword

import android.util.Patterns
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ForgotPasswordViewModel : ViewModel() {
    var forgotPasswordState = mutableStateOf(ForgotPasswordState())
        private set

    val emailHasError = derivedStateOf {
        if(forgotPasswordState.value.email.isEmpty()) return@derivedStateOf false
        !Patterns.EMAIL_ADDRESS.matcher(forgotPasswordState.value.email).matches()
    }

    fun setEmail(email: String) {
        forgotPasswordState.value = forgotPasswordState.value.copy(email = email)
    }
    var popupVisible = mutableStateOf(false)
        private set

    fun showPopup() {
        popupVisible.value = true
    }

    fun hidePopup() {
        popupVisible.value = false
    }
}