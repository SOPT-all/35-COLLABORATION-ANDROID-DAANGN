package org.sopt.carrot.presentation.titleSearchScreen.components.product

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.carrot.R
import org.sopt.carrot.data.model.response.Product

@Composable
fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 18.dp)
            .clickable { }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(17.dp)
        ) {
            ProductImage(
                imageUrl = product.product_image
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(108.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                ProductInfo(
                    title = product.title,
                    address = product.address,
                    price = product.price
                )
                ProductLikeButton(
                    likeCount = product.id.toString()
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    ProductItem(
        product = Product(
            id = 1,
            user_id = 1,
            product_image = "android.resource://${R.drawable.img_list_search_1.toString()}",
            title = "앤유 하프집업 맨투맨 좋은 상품입니다",
            address = "방이동",
            price = "24,000"
        )
    )

}

@Preview(showBackground = true)
@Composable
private fun ProductItemLongTextPreview() {
    ProductItem(
        product = Product(
            id = 2,
            user_id = 2,
            product_image = "~~~~~",
            title = "이것은 매우 긴 제목의 상품입니다. 이렇게 길게 작성하면 2줄까지만 보여주고 나머지는 ... 처리가 되어야 합니다.",
            address = "송파구 잠실동",
            price = "168,000"
        )
    )
}
