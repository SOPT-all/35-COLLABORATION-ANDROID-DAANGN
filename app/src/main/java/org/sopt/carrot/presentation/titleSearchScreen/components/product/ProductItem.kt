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
import org.sopt.carrot.domain.model.SearchProduct
import org.sopt.carrot.domain.model.SearchSimilarProduct

@Composable
fun ProductItem(
    product: Any,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val id:Long
    val title: String?
    val productImage: String
    val address: String?
    val price: String
    when(product) {
        is SearchProduct -> {
            id = product.id
            title = product.title
            productImage = product.productImage
            address = product.address
            price = product.price
        }

        is SearchSimilarProduct -> {
            id = product.id
            title = product.title
            productImage = product.productImage
            address = product.address
            price = product.price
        }

        else -> throw IllegalArgumentException("괴롭히지마!!!!!")
    }
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
                imageUrl = productImage
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                ProductInfo(
                    title = title,
                    address = address,
                    price = price
                )
                ProductLikeButton(
                    likeCount = id.toString(),
                )
            }
        }
    }
}
