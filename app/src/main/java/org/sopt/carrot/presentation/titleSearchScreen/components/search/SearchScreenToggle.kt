package org.sopt.carrot.presentation.titleSearchScreen.components.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.carrot.R
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun SearchScreenToggle(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.size(width = 116.dp, height = 28.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_check_28),
            contentDescription = "판매중만 보기 체크",
            tint = Color.Unspecified,
            modifier = modifier.size(28.dp)
        )
        Text(
            text = "판매중만 보기",
            style = CarrotTheme.typography.body.md_15,
            color = CarrotTheme.colors.gray8
        )
    }
}

@Preview
@Composable
private fun SearchScreenTogglePreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        SearchScreenToggle()
    }
}
