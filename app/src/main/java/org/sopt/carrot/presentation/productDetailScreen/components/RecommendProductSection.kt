package org.sopt.carrot.presentation.productDetailScreen.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.carrot.R
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun RecommendProductSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = stringResource(R.string.also_viewed_with_post),
            style = CarrotTheme.typography.body.md_17,
            color = CarrotTheme.colors.gray8
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(17.dp), // 17.dp로 수정
            verticalArrangement = Arrangement.spacedBy(27.dp),
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 700.dp)
                .wrapContentHeight(),
            userScrollEnabled = false
        ) {
            recommendItems.forEach { item ->
                item {
                    RecommendProductItem(
                        image = item.image,
                        title = item.title,
                        price = item.price
                    )
                }
            }
        }
    }
}

@Composable
private fun RecommendProductItem(
    image: Int,
    title: String,
    price: String,
    modifier: Modifier = Modifier
) {
    val showReservation = title.length % 2 == 1

    Column(
        modifier = modifier
            .fillMaxWidth() // fillMaxWidth(0.45f) 제거
            .fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(181f / 136f)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(6.dp)),
                contentScale = ContentScale.Crop
            )

            if (showReservation) {
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(
                            color = CarrotTheme.colors.green,
                            shape = RoundedCornerShape(4.dp)
                        )
                ) {
                    Text(
                        text = stringResource(R.string.status_reserved),
                        style = CarrotTheme.typography.caption.b_11,
                        color = CarrotTheme.colors.white,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }
        }
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                text = title,
                style = CarrotTheme.typography.body.md_15_05,
                color = CarrotTheme.colors.gray8,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = price,
                style = CarrotTheme.typography.body.b_14,
                color = CarrotTheme.colors.gray8
            )
        }
    }
}

private val recommendItems = listOf(
    RecommendItem(
        image = R.drawable.img_vince_hood,
        title = "Vince 빈스 테디베어 후드",
        price = "80,000원"
    ),
    RecommendItem(
        image = R.drawable.img_comme_tee,
        title = "꼼데가르송 보더티 네이비",
        price = "28,000원"
    ),
    RecommendItem(
        image = R.drawable.img_emu_top,
        title = "(미착용) 에뮤 여성탑",
        price = "65,000원"
    ),
    RecommendItem(
        image = R.drawable.img_descent_hood,
        title = "데상트 크롭 후드티",
        price = "14,000원"
    )
)

private data class RecommendItem(
    @DrawableRes val image: Int,
    val title: String,
    val price: String
)

@Preview(showBackground = true)
@Composable
private fun RecommendProductSectionPreview() {
    RecommendProductSection()
}
