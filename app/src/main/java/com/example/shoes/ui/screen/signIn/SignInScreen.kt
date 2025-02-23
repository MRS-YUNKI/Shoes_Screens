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
import androidx.compose.ui.text.input.PasswordVisualTransformation


@Composable
fun SignInScreen(){
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
                        .clickable {

                        }
                )
            }
        }
    ) { paddingValues ->
        SignInContent(paddingValues)
    }
}

@Composable
fun SignInContent(paddingValues: PaddingValues){
    Column (
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {
        TitleWithSubtitleText(
            title = stringResource(R.string.hello),
            subTitle = stringResource(R.string.sign_in_up_subtitle)
        )

        val email = remember { mutableStateOf("") }
        Spacer(modifier = Modifier.height((35.dp)))
        AuthTextFiled(
            labelText = stringResource(R.string.email),
            placeHolder = {
                Text(
                    text = stringResource(R.string.template_email),
                    style = ShoesTheme.typography.bodyRegular14.copy(color = ShoesTheme.colors.hint)
                )
            },
            value = email.value,
            onChangeValue = {
                email.value = it
            }
        )

        val password = remember { mutableStateOf("") }
        Spacer(modifier = Modifier.height((30.dp)))
        AuthTextFiled(
            labelText = stringResource(R.string.password),
            placeHolder = {
                Image(
                    painter = painterResource(R.drawable.dots),
                    contentDescription = null
                )
            },
            value = password.value,
            onChangeValue = {
                password.value = it
            },
            isPassword = true
        )

        Text(
            text = stringResource(R.string.reset_password),
            style = ShoesTheme.typography.bodyRegular12.copy(ShoesTheme.colors.subTextDark),
            modifier = Modifier
                .padding(top = 12.dp, end = 24.dp)
                .align(Alignment.End)
                .clickable { }
        )

        AuthCommonButton(
            modifier = Modifier.padding(top = 24.dp),
            buttonLabel = stringResource(R.string.sign_in)){

        }
    }
}

@Composable
fun TitleWithSubtitleText(title: String, subTitle: String){
    Column (
        modifier = Modifier.padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text (
            text = title,
            style = ShoesTheme.typography.headingBold32.copy(color = ShoesTheme.colors.text),
            textAlign = TextAlign.Center
        )
        Text (
            modifier = Modifier.padding(top = 8.dp),
            text = subTitle,
            style = ShoesTheme.typography.subTitleRegular16.copy(color = ShoesTheme.colors.subTextDark),
            textAlign = TextAlign.Center
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthTextFiled(
    value: String,
    onChangeValue: (String) -> Unit,
    placeHolder: @Composable (() -> Unit)? = null,
    labelText: String? = null,
    isPassword: Boolean = false
) {
    val isPasswordVisible = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .wrapContentSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        if (labelText != null) {
            Text(
                text = labelText,
                style = ShoesTheme.typography.bodyRegular16.copy(ShoesTheme.colors.text),
                textAlign = TextAlign.Right
            )
        }
        val interaction = remember { MutableInteractionSource() }

        Box(modifier = Modifier.fillMaxWidth()) {
            BasicTextField(
                value = value,
                onValueChange = { onChangeValue(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(ShoesTheme.colors.background)
                    .padding(end = 24.dp),
                visualTransformation = if (isPassword && !isPasswordVisible.value) PasswordVisualTransformation() else VisualTransformation.None
            ) { innerTextField ->
                TextFieldDefaults.DecorationBox(
                    value = value,
                    innerTextField = innerTextField,
                    enabled = true,
                    singleLine = true,
                    visualTransformation = VisualTransformation.None,
                    interactionSource = interaction,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = ShoesTheme.colors.background,
                        disabledContainerColor = ShoesTheme.colors.background,
                        unfocusedContainerColor = ShoesTheme.colors.background,
                        errorContainerColor = ShoesTheme.colors.background,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent
                    ),
                    placeholder = placeHolder
                )
            }
            if (isPassword) {
                IconButton(
                    onClick = { isPasswordVisible.value = !isPasswordVisible.value },
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 7.dp)
                ) {
                    val icon = if (isPasswordVisible.value) {
                        R.drawable.open_eye
                    } else {
                        R.drawable.close_eye
                    }
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = null,
                        tint = ShoesTheme.colors.hint,
                        modifier = Modifier.width(16.37.dp).height(13.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun AuthCommonButton(modifier: Modifier, buttonLabel: String, onClick: () -> Unit) {
    Button(
        modifier = modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(14.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = ShoesTheme.colors.accent),
        onClick = onClick
    ) {
        Text(
            text = buttonLabel,
            style = ShoesTheme.typography.bodyRegular16.copy(color = ShoesTheme.colors.background),
            textAlign = TextAlign.Center
        )
    }
}