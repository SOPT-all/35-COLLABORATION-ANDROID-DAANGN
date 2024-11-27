package org.sopt.carrot.presentation.productDetailScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.sopt.carrot.R
import org.sopt.carrot.core.extension.noRippleClickable
import org.sopt.carrot.ui.theme.White


@Composable
private fun TopBarIcon(
    iconRes: Int,
    contentDescription: String,
    tint: Color = White,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Icon(
        modifier = modifier.noRippleClickable { onClick() },
        painter = painterResource(id = iconRes),
        contentDescription = contentDescription,
        tint = tint
    )
}

@Composable
fun ProductTopBar(
    onBackClick: () -> Unit,
    onHomeClick: () -> Unit,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    val iconTint = if (backgroundColor.luminance() < 0.5f) Color.White else Color.Black

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 45.dp, start = 16.dp, end = 16.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TopBarIcon(
                iconRes = R.drawable.ic_direction_left_white_28,
                contentDescription = "뒤로가기",
                tint = iconTint,
                onClick = onBackClick
            )
            Spacer(modifier = Modifier.width(12.dp))
            TopBarIcon(
                iconRes = R.drawable.ic_home_white_28,
                contentDescription = "홈",
                tint = iconTint,
                onClick = onHomeClick
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            TopBarIcon(
                iconRes = R.drawable.ic_share_white_28,
                contentDescription = "공유하기",
                tint = iconTint,
                onClick = { /* Share */ }
            )
            Spacer(modifier = Modifier.width(12.dp))
            TopBarIcon(
                iconRes = R.drawable.ic_menu_kebab_white_18,
                contentDescription = "더보기",
                tint = iconTint,
                onClick = { /* More */ }
            )
        }
    }
}
