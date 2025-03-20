package com.example.shoes.ui.screen.signUp

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shoes.data.Auth
import com.example.shoes.data.domain.usecase.AuthUseCase
import com.example.shoes.ui.screen.signUp.component.RegButton
import com.example.shoes.ui.screen.signUp.component.RegTextField
import com.example.shoes.ui.screen.signUp.component.TitleWithSubtitleText


@Composable
fun SignUpScreen(authUseCase: AuthUseCase, onNavigationToProfile: () -> Unit){
    val signUpViewModel = SignUpViewModel(authUseCase)
    val snackBarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(snackBarHostState)},
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
                    text = stringResource(R.string.sign_in_down),
                    style = ShoesTheme.typography.bodyRegular16.copy(color = ShoesTheme.colors.subTextDark),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .clickable {

                        }
                )
            }
        }
    ) { paddingValues ->
        SignUpContent(paddingValues, signUpViewModel, onNavigationToProfile, snackBarHostState)
    }
}

@Composable
fun SignUpContent(paddingValues: PaddingValues, signUpViewModel: SignUpViewModel, onNavigationToProfile: () -> Unit, snackbarHostState: SnackbarHostState){
    val signUpState = signUpViewModel.signUpState.value
    LaunchedEffect(signUpState.isSignUp) {
        if (signUpState.isSignUp) {
            onNavigationToProfile()
        }
    }
    LaunchedEffect(signUpState.errorMessage) {
        signUpState.errorMessage?.let {
            snackbarHostState.showSnackbar(it)
        }
    }
    Column (
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {
        TitleWithSubtitleText(
            title = stringResource(R.string.sign_up_up),
            subTitle = stringResource(R.string.sign_in_up_subtitle)
        )

        Spacer(modifier = Modifier.height((35.dp)))
        RegTextField(
            placeholder = {
                Text(
                    text = stringResource(R.string.template_name),
                    style = ShoesTheme.typography.bodyRegular14.copy(color = ShoesTheme.colors.hint)
                )
            },
            value = signUpState.name,
            onChangeValue = {
                signUpViewModel.setName(it)
            },
            isError = signUpViewModel.nameHasError.value,
            supportingText = {
                Text(
                    text = stringResource(R.string.incorrect_name)
                )
            },
            label = {
                Text(
                    text = stringResource(R.string.name),
                    style = ShoesTheme.typography.bodyRegular16.copy(ShoesTheme.colors.text)
                )
            }
        )

        Spacer(modifier = Modifier.height((12.dp)))
        RegTextField(
            placeholder = {
                Text(
                    text = stringResource(R.string.template_email),
                    style = ShoesTheme.typography.bodyRegular14.copy(color = ShoesTheme.colors.hint)
                )
            },
            value = signUpState.email,
            onChangeValue = {
                signUpViewModel.setEmail(it)
            },
            isError = signUpViewModel.emailHasError.value,
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

        Spacer(modifier = Modifier.height((12.dp)))
        RegTextField(
            placeholder = {
                Image(
                    painter = painterResource(id = R.drawable.dots),
                    contentDescription = null
                )
            },
            value = signUpState.password,
            onChangeValue = {
                signUpViewModel.setPassword(it)
            },
            isPassword = true,
            isPasswordVisible = signUpState.isVisiblePassword,
            togglePasswordVisibility = { signUpViewModel.togglePasswordVisibility() },
            isError = signUpViewModel.passwordHasError.value,
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

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 12.dp)
                .clickable {

                }
        ) {
            Spacer(modifier = Modifier.padding(12.dp))
            Icon(
                painter = painterResource(R.drawable.personal_data),
                contentDescription = null,
                modifier = Modifier.size(10.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.padding(12.dp))
            Text(
                text = stringResource(R.string.personal_data),
                style = ShoesTheme.typography.bodyRegular16.copy(ShoesTheme.colors.subTextDark),
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .padding(end = 22.dp)
                    .clickable { }
            )
        }

        RegButton(
            onClick = {
                signUpViewModel.registration()
            }
        ) {
          Text(stringResource(R.string.sign_up))
            if (signUpState.isLoading) CircularProgressIndicator(color = Color.Blue)
        }
    }
}