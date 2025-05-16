package com.example.shoes.ui.screen.signIn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shoes.data.domain.usecase.AuthUseCase
import com.example.shoes.ui.screen.signIn.component.AuthButton
import com.example.shoes.ui.screen.signIn.component.AuthTextField
import com.example.shoes.ui.screen.signIn.component.TitleWithSubtitleText


@Composable
fun SignInScreen(
    authUseCase: AuthUseCase,
    onNavigateToSignUp: () -> Unit,
    onSignInSuccess: () -> Unit,
    onNavigateToForgotPassword: () -> Unit
) {
    val signInViewModel: SignInViewModel = viewModel()
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .padding(top = 35.dp)
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
        },
        bottomBar = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(bottom = 50.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.sign_up_down),
                    style = ShoesTheme.typography.bodyRegular16.copy(color = ShoesTheme.colors.subTextDark),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .clickable (
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) {
                            onNavigateToSignUp()
                        }
                )
            }
        }
    ) { paddingValues ->
        SignInContent(paddingValues, signInViewModel, onSignInSuccess, onNavigateToForgotPassword)
    }
}

@Composable
fun SignInContent(paddingValues: PaddingValues, signInViewModel: SignInViewModel, onSignInSuccess: () -> Unit, onNavigateToForgotPassword: () -> Unit) {
    val signInState = signInViewModel.signInState.value

    Column(
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {
        TitleWithSubtitleText(
            title = stringResource(R.string.hello),
            subTitle = stringResource(R.string.sign_in_up_subtitle)
        )

        Spacer(modifier = Modifier.height((35.dp)))
        AuthTextField(
            placeholder = {
                Text(
                    text = stringResource(R.string.template_email),
                    style = ShoesTheme.typography.bodyRegular14.copy(color = ShoesTheme.colors.hint)
                )
            },
            value = signInState.email,
            onChangeValue = {
                signInViewModel.setEmail(it)
            },
            isError = signInViewModel.emailHasError.value,
            supportingText = {
                Text(
                    text = stringResource(R.string.incorrect_email)
                )
            },
            label = {
                Text(
                    text = stringResource(R.string.email),
                    style = ShoesTheme.typography.bodyRegular16.copy(ShoesTheme.colors.text)
                )
            }
        )

        Spacer(modifier = Modifier.height((30.dp)))
        AuthTextField(
            placeholder = {
                Image(
                    painter = painterResource(R.drawable.dots),
                    contentDescription = null
                )
            },
            value = signInState.password,
            onChangeValue = {
                signInViewModel.setPassword(it)
            },
            isPassword = true,
            isPasswordVisible = signInState.isVisiblePassword,
            togglePasswordVisibility = { signInViewModel.togglePasswordVisibility() },
            isError = signInViewModel.passwordHasError.value,
            supportingText = {
                Text(
                    text = stringResource(R.string.incorrect_password)
                )
            },
            label = {
                Text(
                    text = stringResource(R.string.password),
                    style = ShoesTheme.typography.bodyRegular16.copy(ShoesTheme.colors.text)
                )
            }
        )

        Text(
            text = stringResource(R.string.reset_password),
            style = ShoesTheme.typography.bodyRegular12.copy(ShoesTheme.colors.subTextDark),
            modifier = Modifier
                .padding(top = 12.dp, end = 24.dp)
                .align(Alignment.End)
                .clickable (
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    onNavigateToForgotPassword()
                }
        )

        AuthButton(
            onClick = onSignInSuccess
        ) {
            Text(stringResource(R.string.sign_in))
        }
    }
}