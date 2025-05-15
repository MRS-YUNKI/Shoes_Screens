package com.example.shoes.ui.screen.OnBoard.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shoes.ui.common.CommonButton
import com.example.shoes.ui.theme.ShoesTheme

@Composable
fun OnBoardButton (
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    CommonButton(
        onClick = onClick,
        buttonColors = ButtonDefaults.buttonColors(
            contentColor = ShoesTheme.colors.text,
            containerColor = ShoesTheme.colors.block,
            disabledContentColor = ShoesTheme.colors.block,
            disabledContainerColor = ShoesTheme.colors.block
        ),
        modifier = modifier
            .padding(bottom = 36.dp)
    ) {
        content()
    }
}