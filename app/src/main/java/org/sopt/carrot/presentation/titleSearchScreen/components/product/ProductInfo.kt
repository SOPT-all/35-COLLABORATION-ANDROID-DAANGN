package org.sopt.carrot.presentation.titleSearchScreen.components.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.sopt.carrot.ui.theme.CarrotTheme


@Composable
fun ProductInfo(
    title: String,
    address: String,
    price: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = modifier
    ) {
        Text(
            text = title,
            style = CarrotTheme.typography.body.md_17,
            color = CarrotTheme.colors.gray8,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = address,
            style = CarrotTheme.typography.body.md_14_03,
            color = CarrotTheme.colors.gray6
        )
        Text(
            text = "${price}원",
            style = CarrotTheme.typography.body.sb_17_08,
            color = CarrotTheme.colors.gray8
        )
    }
}
