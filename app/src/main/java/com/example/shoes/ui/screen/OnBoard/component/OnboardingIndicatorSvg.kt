package com.example.shoes.ui.screen.OnBoard.OnBoard1Screen.component
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.shoes.R
@Composable
fun OnboardingIndicatorSvg(
    totalDots: Int,
    selectedIndex: Int,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        repeat(totalDots) { index ->
            val (resId, size) = if (index == selectedIndex) {
                R.drawable.line_33 to 43.dp
            } else {
                R.drawable.line_34 to 28.dp
            }

            Image(
                painter = painterResource(id = resId),
                contentDescription = null,
                modifier = Modifier.size(size)
            )
        }
    }
}