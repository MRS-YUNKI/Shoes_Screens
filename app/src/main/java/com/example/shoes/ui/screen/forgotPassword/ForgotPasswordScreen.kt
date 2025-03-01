package com.example.shoes.ui.screen.forgotPassword

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.shoes.R
import com.example.shoes.ui.theme.ShoesTheme
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shoes.ui.screen.forgotPassword.component.ForgotPasswordButton
import com.example.shoes.ui.screen.forgotPassword.component.ForgotPasswordTextField
import com.example.shoes.ui.screen.forgotPassword.component.TitleWithSubtitleText
import com.example.shoes.ui.screen.signUp.SignUpViewModel


@Composable
fun ForgotPasswordScreen(){
    val forgotPasswordViewModel: ForgotPasswordViewModel = viewModel()
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .padding(top = 45.dp)
                    .fillMaxWidth()
                    .height(40.dp)
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(R.drawable.back_arrow),
                        contentDescription = null
                    )
                }
            }
        }
    ) { paddingValues ->
        ForgotPasswordContent(paddingValues, forgotPasswordViewModel)
    }
}

@Composable
fun ForgotPasswordContent(paddingValues: PaddingValues, forgotPasswordViewModel: ForgotPasswordViewModel){
    val forgotPasswordState = forgotPasswordViewModel.forgotPasswordState.value
    Column (
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {
        TitleWithSubtitleText(
            title = stringResource(R.string.forgot_password_title),
            subTitle = stringResource(R.string.forgot_password_subtitle)
        )

        Spacer(modifier = Modifier.height((40.dp)))
        ForgotPasswordTextField(
            placeholder = {
                Text(
                    text = stringResource(R.string.template_email),
                    style = ShoesTheme.typography.bodyRegular14.copy(color = ShoesTheme.colors.hint)
                )
            },
            value = forgotPasswordState.email,
            onChangeValue = {
                forgotPasswordViewModel.setEmail(it)
            },
            isError = forgotPasswordViewModel.emailHasError.value,
            supportingText = {
                Text(
                    text = stringResource(R.string.incorrect_email)
                )
            },
            label = {
            }
        )

        ForgotPasswordButton(
            onClick = {},
        ) {
            Text(stringResource(R.string.send_message))
        }
    }
}