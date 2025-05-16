package com.example.shoes.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.shoes.R

@Immutable
data class ShoesColors(
    val block: Color,
    val text: Color,
    val subTextDark: Color,
    val subTextLight: Color,
    val background: Color,
    val hint: Color,
    val accent: Color
)

@Immutable
data class ShoesTextStyles(
    val headingBold32: TextStyle,
    val headingBold30: TextStyle,
    val subTitleRegular16: TextStyle,
    val bodyRegular16: TextStyle,
    val bodyRegular14: TextStyle,
    val bodyRegular12: TextStyle
)

val LocalShoesTypography = staticCompositionLocalOf {
    ShoesTextStyles(
        headingBold32 = TextStyle.Default,
        headingBold30 = TextStyle.Default,
        subTitleRegular16 = TextStyle.Default,
        bodyRegular16 = TextStyle.Default,
        bodyRegular14 = TextStyle.Default,
        bodyRegular12 = TextStyle.Default
    )
}

val LocalShoesColors = staticCompositionLocalOf {
    ShoesColors(
        block = Color.Unspecified,
        text = Color.Unspecified,
        subTextDark = Color.Unspecified,
        subTextLight = Color.Unspecified,
        background = Color.Unspecified,
        hint = Color.Unspecified,
        accent = Color.Unspecified
    )
}

val shoesFontFamily = FontFamily(
    Font(R.font.roboto_serif, FontWeight.Normal),
    Font(R.font.roboto_serif_bold, FontWeight.Bold),
    Font(R.font.roboto_serif_black, FontWeight.Black),
    Font(R.font.roboto_serif_medium, FontWeight.Medium),
    Font(R.font.roboto_serif_extrabold, FontWeight.ExtraBold),
    Font(R.font.roboto_serif_semibold, FontWeight.SemiBold),
    Font(R.font.raleway, FontWeight.Normal)
)

@Composable
fun ShoesTheme(content: @Composable () -> Unit){
    val shoesColors = ShoesColors(
        block = Color(0xFFFFFFFF),
        text = Color(0xFF2B2B2B),
        subTextDark = Color(0xFF707B81),
        subTextLight = Color(0xFFD8D8D8),
        background = Color(0xFFF7F7F9),
        hint = Color(0xFF6A6A6A),
        accent = Color(0xFF48B2E7)
    )
    val shoesTypography = ShoesTextStyles(
        headingBold32 = TextStyle(fontFamily = shoesFontFamily, fontWeight = FontWeight.Bold, fontSize = 32.sp),
        headingBold30 = TextStyle(fontFamily = shoesFontFamily, fontWeight = FontWeight.Normal, fontSize = 30.sp),
        subTitleRegular16 = TextStyle(fontFamily = shoesFontFamily, fontWeight = FontWeight.Normal, fontSize = 16.sp),
        bodyRegular16 = TextStyle(fontFamily = shoesFontFamily, fontWeight = FontWeight.Normal, fontSize = 16.sp),
        bodyRegular14 = TextStyle(fontFamily = shoesFontFamily, fontWeight = FontWeight.Normal, fontSize = 14.sp),
        bodyRegular12 = TextStyle(fontFamily = shoesFontFamily, fontWeight = FontWeight.Normal, fontSize = 12.sp)

    )
    CompositionLocalProvider (
        LocalShoesColors provides shoesColors,
        LocalShoesTypography provides shoesTypography,
        content = content
    )
}

object ShoesTheme {
    val colors: ShoesColors
    @Composable
    get() = LocalShoesColors.current

    val typography
    @Composable
    get() = LocalShoesTypography.current
}
