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
    val id = when(product) {
        is SearchProduct -> product.id
        is SearchSimilarProduct -> product.id
        else -> return
    }
    val title = when(product) {
        is SearchProduct -> product.title
        is SearchSimilarProduct -> product.title
        else -> return
    }
    val productImage = when(product) {
        is SearchProduct -> product.productImage
        is SearchSimilarProduct -> product.productImage
        else -> return
    }
    val address = when(product) {
        is SearchProduct -> product.address
        is SearchSimilarProduct -> product.address
        else -> return
    }
    val price = when(product) {
        is SearchProduct -> product.price
        is SearchSimilarProduct -> product.price
        else -> return
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
