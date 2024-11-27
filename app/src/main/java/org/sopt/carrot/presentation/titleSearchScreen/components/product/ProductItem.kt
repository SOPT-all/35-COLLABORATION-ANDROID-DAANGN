package org.sopt.carrot.presentation.titleSearchScreen.components.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.sopt.carrot.core.extension.noRippleClickable
import org.sopt.carrot.domain.model.SearchModel

@Composable
fun ProductItem(
    product: SearchModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 18.dp)
            .noRippleClickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(17.dp)
        ) {
            ProductImage(
                imageUrl = product.productImage
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                ProductInfo(
                    title = product.title,
                    address = product.address,
                    price = product.price
                )
                ProductLikeButton(
                    likeCount = product.id.toString(),
                )
            }
        }
    }
}
