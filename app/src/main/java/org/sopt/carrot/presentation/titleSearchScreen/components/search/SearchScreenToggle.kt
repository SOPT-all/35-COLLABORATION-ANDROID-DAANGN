package org.sopt.carrot.presentation.titleSearchScreen.components.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import org.sopt.carrot.R
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun SearchScreenToggle(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_check_28),
            contentDescription = "판매중만 보기 체크",
            tint = Color.Unspecified,
        )
        Text(
            text = "판매중만 보기",
            style = CarrotTheme.typography.body.md_15,
            color = CarrotTheme.colors.gray8
        )
    }
}

