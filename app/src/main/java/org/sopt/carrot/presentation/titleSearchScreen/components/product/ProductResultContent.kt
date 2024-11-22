package org.sopt.carrot.presentation.titleSearchScreen.components.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.carrot.R
import org.sopt.carrot.data.model.response.Product
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun ProductResultContent(
    products: List<Product>,
    similarProducts: List<Product>,
    searchQuery: String,
    onProductClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(CarrotTheme.colors.white)
            .padding(horizontal = 16.dp)
    ) {
        // 메인 상품 리스트
        if (products.isNotEmpty()) {
            itemsIndexed(
                items = products,
                key = { _, item -> item.id }
            ) { index, product ->
                ProductItem(
                    product = product,
                    onClick = { onProductClick(product.id) }
                )
                if (index < products.size - 1) {  // 메인 상품 리스트의 마지막이 아닐 때만
                    HorizontalDivider(
                        color = CarrotTheme.colors.gray2,
                        thickness = 1.dp
                    )
                }
            }
        }

        // 유사 상품 섹션
        if (similarProducts.isNotEmpty()) {

            item {
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth(),
                    thickness = 8.dp,
                    color = CarrotTheme.colors.gray2
                )
            }

            item {
                SimilarProductsHeader(
                    searchQuery = searchQuery,
                )
            }

            itemsIndexed(
                items = similarProducts,
                key = { _, item -> item.id }
            ) { index, product ->
                ProductItem(
                    product = product,
                    onClick = { onProductClick(product.id) }
                )
                if (index < similarProducts.size - 1) {  // 유사 상품 리스트의 마지막이 아닐 때만
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = CarrotTheme.colors.gray2
                    )
                }
            }
        }

        // 빈 결과
        if (products.isEmpty() && similarProducts.isEmpty()) {
            item {
                EmptyResultMessage()
            }
        }
    }
}

@Composable
private fun SimilarProductsHeader(
    searchQuery: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(top = 18.dp)) {
        Text(
            text = "원하는 매물을 찾지 못하셨나요?",
            style = CarrotTheme.typography.title.b_20_04,
            color = CarrotTheme.colors.gray8,
            modifier = Modifier
        )

        Text(
            text = "${searchQuery}와 유사한 매물을 보여드릴게요.",
            style = CarrotTheme.typography.body.md_15_05,
            color = CarrotTheme.colors.gray5,
            modifier = Modifier
        )
    }
}

