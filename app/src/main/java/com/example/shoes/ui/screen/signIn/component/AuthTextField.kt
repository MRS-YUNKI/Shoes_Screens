package com.example.shoes.ui.screen.signIn.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.shoes.R
import com.example.shoes.ui.common.CommonTextField
import com.example.shoes.ui.theme.ShoesTheme

@Composable
fun AuthTextField(
    value: String,
    onChangeValue: (String) -> Unit,
    isError: Boolean,
    supportingText: @Composable () -> Unit,
    placeholder: @Composable () -> Unit,
    label: @Composable () -> Unit,
    isPassword: Boolean = false,
    isPasswordVisible: Boolean = false,
    togglePasswordVisibility: (() -> Unit)? = null
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
                placeHolder = placeholder,
                visualTransformation = if (isPassword && !isPasswordVisible) {
                    PasswordVisualTransformation()
                } else {
                    VisualTransformation.None
                },
                trailingIcon = {
                    if (isPassword) {
                        Box(
                            modifier = Modifier
                                .wrapContentWidth(Alignment.End)
                                .padding(start = 25.dp)
                        ){
                            IconButton(
                                onClick = { togglePasswordVisibility?.invoke() },
                                modifier = Modifier
                                    .size(24.dp)
                            ) {
                                val icon = if (isPasswordVisible) {
                                    R.drawable.open_eye
                                } else {
                                    R.drawable.close_eye
                                }
                                Icon(
                                    painter = painterResource(id = icon),
                                    contentDescription = null,
                                    tint = ShoesTheme.colors.hint,
                                    modifier = Modifier
                                        .width(24.dp)
                                        .height(24.dp)
                                )
                            }
                        }
                    }
                }
            )
        }
    }
}