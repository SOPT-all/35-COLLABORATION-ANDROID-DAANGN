package org.sopt.carrot.presentation.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.carrot.core.extension.noRippleClickable


@Composable
fun BasicChipButton(
    text: String,
    textStyle: TextStyle,
    textColor: Color,
    icon: Painter? = null,
    iconTint: Color = Color.Unspecified,
    iconModifier: Modifier = Modifier.size(16.dp),
    backgroundColor: Color = Color.White,
    borderColor: Color = Color.Transparent,
    horizontalPadding: Dp = 16.dp,
    verticalPadding: Dp = 8.dp,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(50.dp)
            )
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(50.dp)
            )
            .padding(horizontal = horizontalPadding, vertical = verticalPadding)
            .noRippleClickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = textStyle,
            color = textColor
        )
        if (icon != null) {
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                painter = icon,
                contentDescription = null,
                tint = iconTint,
                modifier = iconModifier
            )
        }
    }
}
