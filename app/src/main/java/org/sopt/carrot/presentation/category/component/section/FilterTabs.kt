package org.sopt.carrot.presentation.category.component.section

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun FilterTabs(
    selectedIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    val tabs = listOf("동네거리", "가격", "카테고리", "정확도순")

    TabRow(
        selectedTabIndex = selectedIndex,
        containerColor = CarrotTheme.colors.white,
        indicator = { tabPositions ->
            TabRowDefaults.SecondaryIndicator(
                modifier = Modifier
                    .tabIndicatorOffset(tabPositions[selectedIndex])
                    .padding(horizontal = 10.dp),
                height = 2.dp,
                color = CarrotTheme.colors.gray8,
            )
        },
        divider = {
            HorizontalDivider(
                thickness = 1.dp,
                color = CarrotTheme.colors.gray2
            )
        },
        tabs = {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    selected = selectedIndex == index,
                    onClick = { onTabSelected(index) },
                    modifier = Modifier
                        .wrapContentWidth()
                        .padding(horizontal = 10.dp),
                    selectedContentColor = CarrotTheme.colors.gray8,
                    unselectedContentColor = CarrotTheme.colors.gray6
                ) {
                    Text(
                        text = tab,
                        style = CarrotTheme.typography.body.b_17,
                        modifier = Modifier.padding(vertical = 13.dp),
                    )
                }
            }
        }
    )
}

@Preview
@Composable
private fun PreviewFilterTabSection() {
    FilterTabs(
        selectedIndex = 2,
        onTabSelected = {}
    )
}
