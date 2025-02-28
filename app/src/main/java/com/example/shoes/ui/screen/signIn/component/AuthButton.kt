package com.example.shoes.ui.screen.signIn.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shoes.R
import com.example.shoes.ui.common.CommonButton
import com.example.shoes.ui.theme.ShoesTheme

@Composable
fun AuthButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    CommonButton(
        onClick = onClick,
        buttonColors = ButtonDefaults.buttonColors(
            contentColor = ShoesTheme.colors.background,
            containerColor = ShoesTheme.colors.accent,
            disabledContentColor = ShoesTheme.colors.accent,
            disabledContainerColor = ShoesTheme.colors.accent
        ),
        modifier = modifier.padding(top = 50.dp),
    ) {
        content()
    }
}