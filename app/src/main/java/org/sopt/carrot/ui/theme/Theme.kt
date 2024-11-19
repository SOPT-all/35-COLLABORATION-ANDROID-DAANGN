package org.sopt.carrot.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

object CarrotTheme {
    val colors: CarrotColors
        @Composable
        @ReadOnlyComposable
        get() = LocalCarrotColors.current

//    val typography: CarrotTypography
//        @Composable
//        @ReadOnlyComposable
//        get() = LocalCarrotTypography.current
}

@Composable
fun ProvideCarrotColorsAndTypography(
    colors: CarrotColors,
//    typography: CarrotTypography,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalCarrotColors provides colors,
//        LocalCarrotTypography provides typography,
        content = content,
    )
}

@Composable
fun CARROTTheme(content: @Composable () -> Unit) {
    ProvideCarrotColorsAndTypography(
        colors = defaultCarrotColors,
//        typography = defaultCarrotTypography
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.run {
                    statusBarColor = White.toArgb()
                    WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars = true
                }
            }
        }
        MaterialTheme(content = content)
    }
}
