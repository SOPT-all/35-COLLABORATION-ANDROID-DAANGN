package org.sopt.carrot.presentation.sellerProfile.component.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.carrot.R
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun BadgeSection() {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp, bottom = 8.dp),
        verticalArrangement = Arrangement.spacedBy(38.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "활동 뱃지 17개",
                color = CarrotTheme.colors.gray8,
                style = CarrotTheme.typography.body.b_18
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_direction_right_28),
                contentDescription = null,
                tint = CarrotTheme.colors.black
            )
        }

        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(22.dp)
        ) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.img_carrier_lg),
                contentDescription = "",
                modifier = Modifier.padding(top = 2.dp, start = 5.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(9.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "배우는 재미",
                    color = CarrotTheme.colors.gray8,
                    style = CarrotTheme.typography.body.extb_14_014,
                )
                Text(
                    text = "판매글이 100개를 돌파했어요! 내가 더는 사용하지 않는물건이 누군가에겐 꼭 필요한 물건이에요. 오늘 비우는 기쁨을 느껴보세요.",
                    color = CarrotTheme.colors.gray8,
                    style = CarrotTheme.typography.body.sb_14_22_028
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewBadgeSection() {
    BadgeSection()
}
