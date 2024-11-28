package org.sopt.carrot.presentation.sellerProfile.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.carrot.R
import org.sopt.carrot.core.extension.noRippleClickable
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun SellerProfileTopBar(
    onBackClick: () -> Unit,
    onShareClick: () -> Unit,
    onMenuClick: () -> Unit,
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, bottom = 12.dp)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_direction_left_black_28),
                    contentDescription = null,
                    modifier = Modifier
                        .noRippleClickable { onBackClick() },
                    tint = Color.Unspecified,
                )
                Text(
                    text = "프로필",
                    color = CarrotTheme.colors.gray8,
                    style = CarrotTheme.typography.title.b_20_04,
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(13.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_share_black_28),
                    contentDescription = null,
                    modifier = Modifier
                        .noRippleClickable { onShareClick() },
                    tint = Color.Unspecified
                )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_menu_kebab_black_18),
                    contentDescription = null,
                    modifier = Modifier
                        .noRippleClickable { onMenuClick() },
                    tint = Color.Unspecified
                )
            }
        }

        HorizontalDivider(
            thickness = 1.dp,
            color = CarrotTheme.colors.gray4
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSellerProfileTopBar() {
    SellerProfileTopBar(
        onBackClick = {},
        onShareClick = {},
        onMenuClick = {},
    )
}
