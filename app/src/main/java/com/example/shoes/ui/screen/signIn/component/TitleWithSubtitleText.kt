package com.example.shoes.ui.screen.signIn.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.shoes.ui.theme.ShoesTheme
import com.example.shoes.ui.theme.shoesFontFamily

@Composable
fun TitleWithSubtitleText(title: String, subTitle: String){
    Column(
        modifier = Modifier.padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = title,
            style = ShoesTheme.typography.headingBold32.copy(color = ShoesTheme.colors.text),
            textAlign = TextAlign.Center
        )

        Text(
            text = subTitle,
            maxLines = 2,
            style = ShoesTheme.typography.bodyRegular16.copy(color = ShoesTheme.colors.subTextDark),
            textAlign = TextAlign.Center
        )
    }
}