package org.sopt.carrot.presentation.category.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.carrot.core.extension.noRippleClickable
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun CategoryBottomBar(
    isEnabled: Boolean,
    onClearSelectedCategories: () -> Unit,
    onApplyCategories: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 28.dp,
                bottom = 60.dp,
                start = 16.dp,
                end = 16.dp
            ),
        horizontalArrangement = Arrangement.spacedBy(19.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .noRippleClickable { onClearSelectedCategories() }
                .background(
                    color = CarrotTheme.colors.gray2,
                    shape = RoundedCornerShape(6.dp)
                )
                .padding(
                    top = 18.dp,
                    bottom = 19.dp,
                    start = 36.dp,
                    end = 36.dp
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "초기화",
                color = CarrotTheme.colors.gray8,
                style = CarrotTheme.typography.body.b_18
            )
        }

        Row(
            modifier = Modifier
                .noRippleClickable { onApplyCategories() }
                .fillMaxWidth()
                .background(
                    color = when (isEnabled) {
                        true -> CarrotTheme.colors.orange1
                        false -> CarrotTheme.colors.gray5
                    },
                    shape = RoundedCornerShape(6.dp)
                )
                .padding(
                    top = 18.dp,
                    bottom = 19.dp
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "적용하기",
                color = CarrotTheme.colors.white,
                style = CarrotTheme.typography.body.b_18
            )
        }
    }
}

@Preview
@Composable
private fun PreviewCategoryBottomBar() {
    Column {
        CategoryBottomBar(
            isEnabled = false,
            onClearSelectedCategories = {},
            onApplyCategories = {}
        )
    }
}

@Preview
@Composable
private fun PreviewCategoryBottomBar2() {
    Column {
        CategoryBottomBar(
            isEnabled = true,
            onClearSelectedCategories = {},
            onApplyCategories = {}
        )
    }
}
