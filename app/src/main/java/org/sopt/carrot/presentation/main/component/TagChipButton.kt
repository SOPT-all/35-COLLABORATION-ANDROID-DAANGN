package org.sopt.carrot.presentation.main.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.sopt.carrot.R
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun TagChipButton(
    text: String,
    onRemoveClick: () -> Unit
) {
    BasicChipButton(
        text = text,
        textStyle = CarrotTheme.typography.body.b_14,
        textColor = CarrotTheme.colors.orange1,
        icon = painterResource(id = R.drawable.ic_delete_orange_18),
        iconTint = CarrotTheme.colors.orange1,
        backgroundColor = Color.White,
        borderColor = CarrotTheme.colors.gray4,
        horizontalPadding = 12.dp,
        onClick = onRemoveClick
    )
}
