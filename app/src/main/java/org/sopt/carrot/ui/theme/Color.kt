package org.sopt.carrot.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf

// Grayscale
val White = Color(0xFFFFFFFF)
val Gray1 = Color(0xFFF7F8FA)
val Gray2 = Color(0xFFF4F5F7)
val Gray3 = Color(0xFFEAEDEF)
val Gray4 = Color(0xFFE0E1E5)
val Gray5 = Color(0xFFADB1BB)
val Gray6 = Color(0xFF868C93)
val Gray7 = Color(0xFF4D5159)
val Gray8 = Color(0xFF212123)
val Black = Color(0xFF000000)

// Orange
val Orange1 = Color(0xFFFF6E10)
val Orange2 = Color(0xFFFFB936)
val Orange3 = Color(0xFFFFEBDD)

// Green
val Green = Color(0xFF1FA174)

// Carrot color scheme class
@Immutable
data class CarrotColors(
    val white: Color,
    val gray1: Color,
    val gray2: Color,
    val gray3: Color,
    val gray4: Color,
    val gray5: Color,
    val gray6: Color,
    val gray7: Color,
    val gray8: Color,
    val black: Color,
    val orange1: Color,
    val orange2: Color,
    val orange3: Color,
    val green: Color
)

// Default color scheme
val DefaultCarrotColors = CarrotColors(
    white = White,
    gray1 = Gray1,
    gray2 = Gray2,
    gray3 = Gray3,
    gray4 = Gray4,
    gray5 = Gray5,
    gray6 = Gray6,
    gray7 = Gray7,
    gray8 = Gray8,
    black = Black,
    orange1 = Orange1,
    orange2 = Orange2,
    orange3 = Orange3,
    green = Green
)

val LocalCarrotColors = staticCompositionLocalOf { DefaultCarrotColors }