package org.sopt.carrot.presentation.titleSearchScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.carrot.data.dto.response.Product
import org.sopt.carrot.presentation.titleSearchScreen.components.product.ProductResultContent
import org.sopt.carrot.presentation.titleSearchScreen.components.search.SearchFilterLayout
import org.sopt.carrot.presentation.titleSearchScreen.components.search.SearchKeywordLayout
import org.sopt.carrot.presentation.titleSearchScreen.components.search.SearchScreenToggle
import org.sopt.carrot.presentation.titleSearchScreen.components.search.SearchTabs
import org.sopt.carrot.presentation.titleSearchScreen.components.search.SearchTopBar
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun TitleSearchScreen(
    onBackClick: () -> Unit,
    onProductClick: (Long) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(CarrotTheme.colors.white)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            SearchTopBar(
                searchQuery = searchQuery,
                onQueryChange = { searchQuery = it },
                onSearch = { },
                onBackClick = onBackClick
            )
        }

        SearchTabs()

        SearchKeywordLayout()

        HorizontalDivider(thickness = 8.dp, color = CarrotTheme.colors.gray2)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            SearchFilterLayout(
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                SearchScreenToggle()
            }
        }
        ProductResultContent(
            products = sampleProducts,
            similarProducts = sampleSimilarProducts,
            searchQuery = searchQuery,
            onProductClick = onProductClick
        )
    }
}


// UI 테스트용 샘플 데이터
private val sampleProducts = listOf(
    Product(
        id = 1,
        user_id = 1,
        product_image = "https://ibb.co/s1y6Nyj",
        title = "맨투맨",
        address = "방이동",
        price = "210,000"
    ),
    Product(
        id = 2,
        user_id = 2,
        product_image = "https://ibb.co/s1y6Nyj",
        title = "레더 맨투맨",
        address = "송파구 잠실동",
        price = "168,000"
    ),
    Product(
        id = 4,
        user_id = 2,
        product_image = "https://ibb.co/s1y6Nyj",
        title = "레더 맨투맨",
        address = "송파구 잠실동",
        price = "168,000"
    ),
    Product(
        id = 5,
        user_id = 2,
        product_image = "https://ibb.co/s1y6Nyj",
        title = "레더 맨투맨",
        address = "송파구 잠실동",
        price = "168,000"
    ),
    Product(
        id = 6,
        user_id = 2,
        product_image = "https://ibb.co/s1y6Nyj",
        title = "레더 맨투맨",
        address = "송파구 잠실동",
        price = "168,000"
    )
)

private val sampleSimilarProducts = listOf(
    Product(
        id = 3,
        user_id = 3,
        product_image = "https://ibb.co/s1y6Nyj",
        title = "DKNY 맨투맨",
        address = "방이동",
        price = "40,000"
    )
)

@Preview(showBackground = true)
@Composable
private fun TitleSearchScreenPreview() {
    TitleSearchScreen(
        onBackClick = {},
        onProductClick = {}
    )
}
