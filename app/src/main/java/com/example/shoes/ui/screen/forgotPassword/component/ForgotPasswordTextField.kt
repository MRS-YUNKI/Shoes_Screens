package com.example.shoes.ui.screen.forgotPassword.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.shoes.R
import com.example.shoes.ui.common.CommonTextField
import com.example.shoes.ui.theme.ShoesTheme

@Composable
fun ForgotPasswordTextField(
    value: String,
    onChangeValue: (String) -> Unit,
    isError: Boolean,
    supportingText: @Composable () -> Unit,
    placeholder: @Composable () -> Unit,
    label: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .wrapContentSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        label()
        Box(modifier = Modifier.fillMaxWidth()) {
            CommonTextField(
                value = value,
                onChangeValue = onChangeValue,
                isError = isError,
                supportingText = supportingText,
                placeHolder = placeholder
            )
        }
    }
}