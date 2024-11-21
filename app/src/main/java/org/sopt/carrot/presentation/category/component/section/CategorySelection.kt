package org.sopt.carrot.presentation.category.component.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.carrot.presentation.category.component.item.CategoryCheckBox

@Composable
fun CategorySelection(
    categories: Map<String, Boolean>,
    onCheckedChange: (String) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(
            items = categories.toList(),
            key = { item: Pair<String, Boolean> -> item.first }
        ) { (category, checked) ->
            Column(
                verticalArrangement = Arrangement.spacedBy(26.dp),
                modifier = Modifier
                    .padding(
                        top = 26.dp,
                        start = 16.dp
                    )
            ) {
                CategoryCheckBox(
                    title = category,
                    checked = checked,
                    onCheckedChange = { onCheckedChange(category) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCategorySelection() {
    val categories = mapOf(
        "디지털기기" to false,
        "옷" to true
    )

    CategorySelection(
        categories = categories,
        onCheckedChange = {}
    )
}
