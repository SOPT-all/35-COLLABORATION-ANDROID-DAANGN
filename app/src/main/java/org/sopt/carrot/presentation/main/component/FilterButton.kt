package org.sopt.carrot.presentation.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.sopt.carrot.R
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun FilterButton(text: String) {
    Row(
        modifier = Modifier
            .background(
                color = Color.White,
                shape = RoundedCornerShape(20.dp)
            )
            .border(
                width = 1.dp,
                color = CarrotTheme.colors.gray3,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = CarrotTheme.typography.body.md_14_03,
            color = CarrotTheme.colors.gray8
        )
        Spacer(modifier = Modifier.width(4.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_direction_down_18),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(16.dp)

        )
    }
}

