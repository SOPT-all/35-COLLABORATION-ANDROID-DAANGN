package org.sopt.carrot.presentation.titleSearchScreen.components.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.carrot.ui.theme.CarrotTheme

private data class KeywordItem(
    val text: String,
    val isFullWidth: Boolean = false
)

private val KeywordItems = listOf(
    KeywordItem("렉토 코트", true),
    KeywordItem("렉토 자켓"),
    KeywordItem("렉토 맨투맨"),
    KeywordItem("렉토 패딩")
)

@Composable
fun SearchKeywordLayout(
    modifier: Modifier = Modifier
) {
    Surface(
        color = CarrotTheme.colors.white,
        modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(KeywordItems) { item ->
                KeywordChip(
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
private fun KeywordChip(
    text: String,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(50.dp),
        color = CarrotTheme.colors.gray2,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(start = 11.dp, end = 11.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = text,
                style = CarrotTheme.typography.body.md_14_03,
                color = CarrotTheme.colors.gray7
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FilterLayoutPreview() {
    SearchKeywordLayout()
}
