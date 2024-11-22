package org.sopt.carrot.presentation.category.component.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.carrot.R
import org.sopt.carrot.core.extension.noRippleClickable
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun CategoryCheckBox(
    title: String,
    checked: Boolean,
    onCheckedChange: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(13.dp, Alignment.Start),
        modifier = Modifier
            .height(22.dp)
            .noRippleClickable { onCheckedChange() }
    ) {
        Icon(
            imageVector = when (checked) {
                true -> ImageVector.vectorResource(R.drawable.ic_checkbox_selected_22)
                false -> ImageVector.vectorResource(R.drawable.ic_checkbox_normal_22)
            },
            contentDescription = "",
            tint = Color.Unspecified
        )
        Text(
            text = title,
            style = CarrotTheme.typography.body.sb_17_08,
            modifier = Modifier.fillMaxHeight()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCategoryCheckBox() {
    var isChecked by remember { mutableStateOf(false) }

    CategoryCheckBox(
        title = "디지털기기",
        checked = isChecked,
        onCheckedChange = { isChecked = !isChecked }
    )
}
