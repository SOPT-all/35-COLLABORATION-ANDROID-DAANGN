package org.sopt.carrot.presentation.sellerProfile.component.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun MannerSection() {
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
                text = "받은 매너 평가",
                color = CarrotTheme.colors.gray8,
                style = CarrotTheme.typography.body.b_18
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_direction_right_28),
                contentDescription = null,
                tint = CarrotTheme.colors.black
            )
        }
        MannerItem("113", "친절하고 매너가 좋아요.")
        MannerItem("109", "시간 약속을 잘 지켜요.")
        MannerItem("106", "응답이 빨라요.")
    }
}

@Composable
fun MannerItem(
    mannerCount: String,
    mannerTitle: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 13.dp),
    ) {
        Row(
            modifier = Modifier
                .padding(
                    top = 2.dp,
                    end = 14.dp
                ),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_people_18),
                contentDescription = null,
                tint = CarrotTheme.colors.gray8
            )
            Text(
                text = mannerCount,
                color = CarrotTheme.colors.gray8,
                style = CarrotTheme.typography.body.md_17,
            )
        }

        Row(
            modifier = Modifier
                .background(
                    color = CarrotTheme.colors.gray2,
                    shape = RoundedCornerShape(
                        topEnd = 11.dp,
                        bottomStart = 11.dp,
                        bottomEnd = 11.dp
                    )
                )
                .padding(
                    vertical = 14.dp,
                    horizontal = 12.dp
                )
        ) {
            Text(
                text = mannerTitle,
                color = CarrotTheme.colors.gray8,
                style = CarrotTheme.typography.body.md_17
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewMannerSection() {
    MannerSection()
}

@Preview(showBackground = true)
@Composable
private fun PreviewMannerItem() {
    MannerItem(
        mannerCount = "113",
        mannerTitle = "친절하고 매너가 좋아요."
    )
}
