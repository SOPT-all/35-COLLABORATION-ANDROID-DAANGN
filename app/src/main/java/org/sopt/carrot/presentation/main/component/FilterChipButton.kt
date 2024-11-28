package org.sopt.carrot.presentation.main.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import org.sopt.carrot.R
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun FilterChipButton(
    text: String,
    onClick: () -> Unit
) {
    BasicChipButton(
        text = text,
        textStyle = CarrotTheme.typography.body.md_14_03,
        textColor = CarrotTheme.colors.gray8,
        icon = painterResource(id = R.drawable.ic_direction_down_18),
        iconTint = Color.Unspecified,
        backgroundColor = Color.White,
        borderColor = CarrotTheme.colors.gray3,
        onClick = onClick
    )
}
