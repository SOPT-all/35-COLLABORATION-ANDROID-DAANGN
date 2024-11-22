package org.sopt.carrot.presentation.category.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.carrot.R
import org.sopt.carrot.core.extension.noRippleClickable
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun CategoryTopBar(
    onBackClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(
                start = 16.dp,
                top = 55.dp
            )
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_direction_left_black_28),
            contentDescription = "",
            modifier = Modifier.noRippleClickable { onBackClick() },
            tint = CarrotTheme.colors.black
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCategoryTopBar() {
    CategoryTopBar(
        onBackClick = {}
    )
}
