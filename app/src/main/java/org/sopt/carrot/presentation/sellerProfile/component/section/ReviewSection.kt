package org.sopt.carrot.presentation.sellerProfile.component.section

import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.carrot.R
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun ReviewSection() {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp, bottom = 34.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "받은 거래 후기 32",
                color = CarrotTheme.colors.gray8,
                style = CarrotTheme.typography.body.b_18_144,
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_direction_right_28),
                contentDescription = null,
                tint = CarrotTheme.colors.black,
            )
        }
        ReviewItem()
        HorizontalDivider(
            thickness = 1.dp,
            color = CarrotTheme.colors.gray3,
            modifier = Modifier.padding(top = 23.dp, bottom = 13.dp)
        )
        ReviewItem()
        HorizontalDivider(
            thickness = 1.dp,
            color = CarrotTheme.colors.gray3,
            modifier = Modifier.padding(top = 23.dp, bottom = 13.dp)
        )
        ReviewItem()
    }
}

@Composable
private fun ReviewItem() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(11.dp)
    ) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.img_user_xs),
            contentDescription = null
        )

        Column(
            modifier = Modifier.padding(top = 4.dp)
        ) {
            Text(
                text = "콤콤",
                color = CarrotTheme.colors.gray8,
                style = CarrotTheme.typography.body.b_14
            )
            Text(
                text = "판매자 · 서울특별시 은평구 · 5달전",
                color = CarrotTheme.colors.gray6,
                style = CarrotTheme.typography.body.r_14,
                modifier = Modifier.padding(top = 4.dp, bottom = 8.dp)
            )
            Text(
                text = "강아지와 여행 잘 다녀오세요:-)",
                color = CarrotTheme.colors.gray8,
                style = CarrotTheme.typography.body.md_17
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewReviewSection() {
    ReviewSection()
}

@Preview(showBackground = true)
@Composable
private fun PreviewReviewItem() {
    ReviewItem()
}
