package org.sopt.carrot.presentation.titleSearchScreen.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.carrot.ui.theme.CarrotTheme


@Composable
fun SearchFilterLayout(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = CarrotTheme.colors.white
    ) {
        LazyRow(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                FilterChip(
                    text = "가락2동 외 59",
                    onClick = { /* TODO */ },
                    modifier = Modifier.width(IntrinsicSize.Max)
                )
            }

            item {
                FilterChip(
                    text = "가격",
                    onClick = { /* TODO */ },
                    modifier = Modifier.wrapContentWidth()
                )
            }

            item {
                FilterChip(
                    text = "카테고리",
                    onClick = { /* TODO */ },
                    modifier = Modifier.wrapContentWidth()
                )
            }

            item {
                FilterChip(
                    text = "정확도순",
                    onClick = { /* TODO */ },
                    modifier = Modifier.wrapContentWidth()
                )
            }
        }
    }
}
@Composable
private fun FilterChip(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(50.dp),
        border = BorderStroke(1.dp, color = CarrotTheme.colors.gray3),
        color = CarrotTheme.colors.white,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = text,
                style = CarrotTheme.typography.body.md_14_03.copy(
                    color = CarrotTheme.colors.gray8
                )
            )
            Icon(
                imageVector = Icons.Rounded.KeyboardArrowDown,
                contentDescription = null,
                tint = Color(0xFF212123)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FilterLayoutPreview() {
    SearchFilterLayout(
        modifier = Modifier.padding(16.dp)
    )
}