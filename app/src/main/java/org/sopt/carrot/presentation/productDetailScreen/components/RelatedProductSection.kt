package org.sopt.carrot.presentation.productDetailScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.carrot.R
import org.sopt.carrot.domain.model.RelatedProduct
import org.sopt.carrot.domain.model.UserDetail
import org.sopt.carrot.ui.theme.CarrotTheme


@Composable
fun RelatedProductSection(
    userInfo: UserDetail,
    relatedProducts: List<RelatedProduct>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.user_selling_items, userInfo.nickname),
                style = CarrotTheme.typography.body.md_17,
                color = CarrotTheme.colors.gray8
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_direction_right_28),
                contentDescription = "다른 판매 물품"
            )
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(17.dp), // 좌우 간격 17dp로 수정
            verticalArrangement = Arrangement.spacedBy(27.dp), // 상하 간격 27dp 유지
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 700.dp)
                .wrapContentHeight(),
            userScrollEnabled = false
        ) {
            items(relatedProducts) { product ->
                RelatedProductItem(product = product)
            }
        }
    }
}

@Composable
private fun RelatedProductItem(
    product: RelatedProduct,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(), // fillMaxWidth(0.45f) 제거하고 전체 너비 사용
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(181f / 136f)  // 비율은 유지
        ) {
            AsyncImage(
                model = product.productImage,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(6.dp)),
                contentScale = ContentScale.Crop
            )
        }
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                text = product.title ?: "",
                style = CarrotTheme.typography.body.md_15_05,
                color = CarrotTheme.colors.gray8,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = product.price,
                style = CarrotTheme.typography.body.b_14,
                color = CarrotTheme.colors.gray8
            )
        }
    }
}
