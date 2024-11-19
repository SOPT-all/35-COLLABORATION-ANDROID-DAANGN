package org.sopt.carrot.presentation.titleSearchScreen.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun SearchScreenToggle(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.size(width = 116.dp, height = 28.dp)
    ) {
        Icon(
            Icons.Default.CheckCircle,
            contentDescription = "판매중만 보기 체크",
            modifier = Modifier.size(28.dp)
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
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)) {
        SearchScreenToggle()
    }
}