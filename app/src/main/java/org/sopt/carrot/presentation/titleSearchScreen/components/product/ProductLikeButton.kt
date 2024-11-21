package org.sopt.carrot.presentation.titleSearchScreen.components.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.carrot.R
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun ProductLikeButton(
    likeCount: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        LikeIcon()
        LikeCount(count = likeCount)
    }
}

@Composable
private fun LikeIcon(
    modifier: Modifier = Modifier
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_like_md_18),
        contentDescription = "좋아요 개수",
        modifier = modifier.size(18.dp)
    )
}

@Composable
private fun LikeCount(
    count: String,
    modifier: Modifier = Modifier
) {
    Spacer(modifier = Modifier.width(4.dp))
    Text(
        text = count,
        color = CarrotTheme.colors.gray7,
        style = CarrotTheme.typography.body.md_14,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductLikeButtonPreview() {
    ProductLikeButton(
        likeCount = "1"
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductLikeButtonLargeNumberPreview() {
    ProductLikeButton(
        likeCount = "999+"
    )
}