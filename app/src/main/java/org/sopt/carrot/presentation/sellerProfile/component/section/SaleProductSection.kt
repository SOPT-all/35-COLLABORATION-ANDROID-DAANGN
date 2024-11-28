package org.sopt.carrot.presentation.sellerProfile.component.section

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
fun SaleProductSection() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "판매 물품 212개",
                color = CarrotTheme.colors.gray8,
                style = CarrotTheme.typography.body.b_18
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_direction_right_28),
                contentDescription = null,
                tint = CarrotTheme.colors.black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSaleProductSection() {
    SaleProductSection()
}
