package org.sopt.carrot.presentation.sellerProfile.component.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
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
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun LocationSection() {
    Column(
        modifier = Modifier
            .background(CarrotTheme.colors.gray2)
            .padding(vertical = 24.dp)
            .padding(start = 14.dp, end = 50.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_ellipse_3),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = "송파구 삼전동 23회 인증, 서울 특별시 강동구 1 회 인증 (최근 30일)",
                color = CarrotTheme.colors.gray7,
                style = CarrotTheme.typography.body.md_14
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_ellipse_3),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Text(
                text = "최근 3일 이내 활동  (2019년 7월  13일 가입)",
                color = CarrotTheme.colors.gray7,
                style = CarrotTheme.typography.body.md_14_20_0
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLocationSection() {
    LocationSection()
}
