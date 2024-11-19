package org.sopt.carrot.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import org.sopt.carrot.R

object PretendardFont {
    val ExtraBold = FontFamily(Font(R.font.pretendard_extrabold))
    val Bold = FontFamily(Font(R.font.pretendard_bold))
    val SemiBold = FontFamily(Font(R.font.pretendard_semibold))
    val Medium = FontFamily(Font(R.font.pretendard_medium))
    val Regular = FontFamily(Font(R.font.pretendard_regular))
    val Black = FontFamily(Font(R.font.pretendard_black))
}

sealed interface TypographyTokens {
    @Immutable
    data class Title(
        val b_25: TextStyle,
        val extb_24_1: TextStyle,
        val b_22_044: TextStyle,
        val b_20_04: TextStyle,
    )

    @Immutable
    data class Body(
        val b_18: TextStyle,
        val b_18_072: TextStyle,
        val b_18_144: TextStyle,
        val md_18_03: TextStyle,
        val b_17: TextStyle,
        val sb_17_08: TextStyle,
        val md_17: TextStyle,
        val md_17_017: TextStyle,
        val b_16_07: TextStyle,
        val b_16_08: TextStyle,
        val md_16_07: TextStyle,
        val extb_15: TextStyle,
        val bla_15_03: TextStyle,
        val bla_15_06: TextStyle,
        val md_15: TextStyle,
        val md_15_05: TextStyle,
        val extb_14_014: TextStyle,
        val b_14: TextStyle,
        val sb_14: TextStyle,
        val sb_14_22_028: TextStyle,
        val md_14: TextStyle,
        val md_14_20_0: TextStyle,
        val md_14_03: TextStyle,
        val md_14_028: TextStyle,
        val r_14: TextStyle,
        val md_13_18_013: TextStyle,
    )

    @Immutable
    data class Caption(
        val md_14_028: TextStyle,
        val r_13: TextStyle,
        val md_12: TextStyle,
        val b_11: TextStyle,
        val md_11: TextStyle,
    )
}

@Immutable
data class CarrotTypography(
    val title: TypographyTokens.Title,
    val body: TypographyTokens.Body,
    val caption: TypographyTokens.Caption
)

val defaultCarrotTypography = CarrotTypography(
    title = TypographyTokens.Title(
        b_25 = TextStyle(
            fontFamily = PretendardFont.Bold,
            fontSize = 25.sp,
            letterSpacing = 0.sp
        ),
        extb_24_1 = TextStyle(
            fontFamily = PretendardFont.ExtraBold,
            fontSize = 24.sp,
            letterSpacing = (-1).sp
        ),
        b_22_044 = TextStyle(
            fontFamily = PretendardFont.Bold,
            fontSize = 22.sp,
            letterSpacing = (-0.44).sp
        ),
        b_20_04 = TextStyle(
            fontFamily = PretendardFont.Bold,
            fontSize = 20.sp,
            letterSpacing = (-0.4).sp
        ),
    ),

    body = TypographyTokens.Body(
        b_18 = TextStyle(
            fontFamily = PretendardFont.Bold,
            fontSize = 18.sp,
            letterSpacing = 0.sp
        ),
        b_18_072 = TextStyle(
            fontFamily = PretendardFont.Bold,
            fontSize = 18.sp,
            letterSpacing = (-0.72).sp
        ),
        b_18_144 = TextStyle(
            fontFamily = PretendardFont.Bold,
            fontSize = 18.sp,
            letterSpacing = (-1.44).sp
        ),
        md_18_03 = TextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 18.sp,
            letterSpacing = (-0.3).sp
        ),
        b_17 = TextStyle(
            fontFamily = PretendardFont.Bold,
            fontSize = 17.sp,
            letterSpacing = 0.sp
        ),
        sb_17_08 = TextStyle(
            fontFamily = PretendardFont.SemiBold,
            fontSize = 17.sp,
            letterSpacing = (-0.8).sp
        ),
        md_17 = TextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 17.sp,
            letterSpacing = 0.sp
        ),
        md_17_017 = TextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 17.sp,
            letterSpacing = 0.17.sp
        ),
        b_16_07 = TextStyle(
            fontFamily = PretendardFont.Bold,
            fontSize = 16.sp,
            letterSpacing = (-0.7).sp
        ),
        b_16_08 = TextStyle(
            fontFamily = PretendardFont.Bold,
            fontSize = 16.sp,
            letterSpacing = (-0.8).sp
        ),
        md_16_07 = TextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 16.sp,
            letterSpacing = (-0.7).sp
        ),
        extb_15 = TextStyle(
            fontFamily = PretendardFont.ExtraBold,
            fontSize = 15.sp,
            letterSpacing = 0.sp
        ),
        bla_15_03 = TextStyle(
            fontFamily = PretendardFont.Black,
            fontSize = 15.sp,
            letterSpacing = (-0.3).sp
        ),
        bla_15_06 = TextStyle(
            fontFamily = PretendardFont.Black,
            fontSize = 15.sp,
            letterSpacing = (-0.6).sp
        ),
        md_15 = TextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 15.sp,
            letterSpacing = 0.sp
        ),
        md_15_05 = TextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 15.sp,
            letterSpacing = (-0.5).sp
        ),
        extb_14_014 = TextStyle(
            fontFamily = PretendardFont.ExtraBold,
            fontSize = 14.sp,
            letterSpacing = (-0.14).sp
        ),
        b_14 = TextStyle(
            fontFamily = PretendardFont.Bold,
            fontSize = 14.sp,
            letterSpacing = 0.sp
        ),
        sb_14 = TextStyle(
            fontFamily = PretendardFont.SemiBold,
            fontSize = 14.sp,
            letterSpacing = 0.sp
        ),
        sb_14_22_028 = TextStyle(
            fontFamily = PretendardFont.SemiBold,
            fontSize = 14.sp,
            lineHeight = 22.sp,
            letterSpacing = (-0.28).sp
        ),
        md_14 = TextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 14.sp,
            letterSpacing = 0.sp
        ),
        md_14_20_0 = TextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.sp
        ),
        md_14_03 = TextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 14.sp,
            letterSpacing = (-0.3).sp
        ),
        md_14_028 = TextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 14.sp,
            letterSpacing = (-0.28).sp
        ),
        r_14 = TextStyle(
            fontFamily = PretendardFont.Regular,
            fontSize = 14.sp,
            letterSpacing = 0.sp
        ),
        md_13_18_013 = TextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 13.sp,
            lineHeight = 18.sp,
            letterSpacing = (-0.13).sp
        ),
    ),

    caption = TypographyTokens.Caption(
        md_14_028 = TextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 14.sp,
            letterSpacing = (-0.28).sp
        ),
        r_13 = TextStyle(
            fontFamily = PretendardFont.Regular,
            fontSize = 13.sp,
            letterSpacing = 0.sp
        ),
        md_12 = TextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 12.sp,
            letterSpacing = 0.sp
        ),
        b_11 = TextStyle(
            fontFamily = PretendardFont.Bold,
            fontSize = 11.sp,
            letterSpacing = 0.sp
        ),
        md_11 = TextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 11.sp,
            letterSpacing = 0.sp
        ),
    ),
)

val LocalCarrotTypography = staticCompositionLocalOf { defaultCarrotTypography }
