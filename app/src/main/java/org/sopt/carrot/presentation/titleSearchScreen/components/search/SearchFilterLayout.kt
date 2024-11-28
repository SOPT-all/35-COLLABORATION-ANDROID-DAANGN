package org.sopt.carrot.presentation.titleSearchScreen.components.search

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.carrot.R
import org.sopt.carrot.core.extension.noRippleClickable
import org.sopt.carrot.ui.theme.CarrotTheme

private data class FilterItem(
    val text: String,
    val isFullWidth: Boolean = false
)

private val filterItems = listOf(
    FilterItem("가락2동 외 59", true),
    FilterItem("가격"),
    FilterItem("카테고리"),
    FilterItem("정확도순")
)

@Composable
fun SearchFilterLayout(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        color = CarrotTheme.colors.white
    ) {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(filterItems) { item ->
                FilterChip(
                    text = item.text,
                    modifier = if (item.isFullWidth) {
                        Modifier.width(IntrinsicSize.Max)
                    } else {
                        Modifier.wrapContentWidth()
                    }
                )
            }
        }
    }
}

@Composable
private fun FilterChip(
    text: String,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(50.dp),
        border = BorderStroke(1.dp, color = CarrotTheme.colors.gray3),
        color = CarrotTheme.colors.white,
        modifier = modifier.noRippleClickable { }
    ) {
        Row(
            modifier = Modifier.padding(start = 11.dp, end = 11.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = text,
                style = CarrotTheme.typography.body.md_14_03,
                color = CarrotTheme.colors.gray8
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_direction_down_18),
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}
