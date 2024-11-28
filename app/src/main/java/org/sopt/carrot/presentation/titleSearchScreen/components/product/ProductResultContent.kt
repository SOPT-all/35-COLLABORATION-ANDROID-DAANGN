package org.sopt.carrot.presentation.titleSearchScreen.components.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.sopt.carrot.R
import org.sopt.carrot.domain.model.Search
import org.sopt.carrot.presentation.titleSearchScreen.components.search.SearchScreenToggle
import org.sopt.carrot.ui.theme.CarrotTheme


@Composable
fun ProductResultContent(
    search: Search,
    searchQuery: String,
    onProductClick: (Long, Long) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(CarrotTheme.colors.white)
    ) {
        // 메인 상품 리스트
        if (search.products.isNotEmpty()) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 6.dp, start = 16.dp, end = 16.dp)
                ) {
                    SearchScreenToggle()
                }
            }
            itemsIndexed(
                items = search.products,
                key = { _, item -> item.id }
            ) { index, product ->
                Column(Modifier.padding(horizontal = 16.dp)) {
                    ProductItem(
                        product = product,
                        onClick = { onProductClick(product.id, product.userId) }
                    )
                    if (index < search.products.size - 1) {
                        HorizontalDivider(
                            color = CarrotTheme.colors.gray2,
                            thickness = 1.dp
                        )
                    }
                }
            }
        }

        // 유사 상품 섹션
        if (search.similarProducts.isNotEmpty()) {
            item {
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 8.dp,
                    color = CarrotTheme.colors.gray2
                )
            }

            item {
                Column(Modifier.padding(horizontal = 16.dp)) {
                    SimilarProductsHeader(searchQuery = searchQuery)
                }
            }

            itemsIndexed(
                items = search.similarProducts,
                key = { _, item -> item.id }
            ) { index, product ->
                Column(Modifier.padding(horizontal = 16.dp)) {
                    ProductItem(
                        product = product,
                        onClick = { onProductClick(product.id, product.userId) }
                    )
                    if (index < search.similarProducts.size - 1) {
                        HorizontalDivider(
                            thickness = 1.dp,
                            color = CarrotTheme.colors.gray2
                        )
                    }
                }
            }
        }

        // 빈 결과
        if (search.products.isEmpty() && search.similarProducts.isEmpty()) {
            item {
                Column(Modifier.padding(horizontal = 16.dp)) {
                    EmptyResultMessage()
                }
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
            text = stringResource(R.string.message_no_find),
            style = CarrotTheme.typography.title.b_20_04,
            color = CarrotTheme.colors.gray8,
            modifier = Modifier
        )

        Text(
            text = stringResource(R.string.message_to_recommend, searchQuery),
            style = CarrotTheme.typography.body.md_15_05,
            color = CarrotTheme.colors.gray5,
            modifier = Modifier
        )
    }
}
