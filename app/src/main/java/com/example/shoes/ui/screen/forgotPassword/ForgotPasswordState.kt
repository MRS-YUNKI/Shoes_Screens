package com.example.shoes.ui.screen.forgotPassword

data class ForgotPasswordState(
    var email: String = "",
    var isLoading: Boolean = false,
    var isForgotPassword: Boolean = false,
    var errorMessage: String? = null
)
