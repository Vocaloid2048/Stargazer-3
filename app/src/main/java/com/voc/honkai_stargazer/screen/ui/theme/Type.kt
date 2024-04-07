package com.voc.honkai_stargazer.screen.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.voc.honkai_stargazer.R
val AppFont = FontFamily(
    Font(R.font.misans_regular)
)
val FontSizeNormalSmall = TextStyle(
    fontFamily = AppFont,
    fontWeight = FontWeight.Medium,
    fontSize = 10.sp
)
val FontSizeNormal = TextStyle(
    fontFamily = AppFont,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp
)
val FontSizeNormal16 = TextStyle(
    fontFamily = AppFont,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp
)
val FontSizeNormalLarge = TextStyle(
    fontFamily = AppFont,
    fontWeight = FontWeight.Medium,
    fontSize = 24.sp,
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodySmall = TextStyle(
        fontFamily = AppFont,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = AppFont,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

