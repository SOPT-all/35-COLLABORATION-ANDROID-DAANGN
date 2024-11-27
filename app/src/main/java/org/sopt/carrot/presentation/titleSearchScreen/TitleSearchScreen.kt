package org.sopt.carrot.presentation.titleSearchScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import org.sopt.carrot.R
import org.sopt.carrot.core.common.ViewModelFactory
import org.sopt.carrot.data.model.SearchProductModel
import org.sopt.carrot.presentation.ScreenRoutes
import org.sopt.carrot.presentation.titleSearchScreen.components.product.ProductResultContent
import org.sopt.carrot.presentation.titleSearchScreen.components.search.SearchFilterLayout
import org.sopt.carrot.presentation.titleSearchScreen.components.search.SearchKeywordLayout
import org.sopt.carrot.presentation.titleSearchScreen.components.search.SearchScreenToggle
import org.sopt.carrot.presentation.titleSearchScreen.components.search.SearchTabs
import org.sopt.carrot.presentation.titleSearchScreen.components.search.SearchTopBar
import org.sopt.carrot.presentation.util.UiState
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun TitleSearchScreen(navController: NavHostController) {
    val viewModel: SearchViewModel = viewModel(factory = ViewModelFactory())
    val searchState by viewModel.searchResults.collectAsState()
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
                onQueryChange = {
                    searchQuery = it
                },
                onSearch = { viewModel.searchProducts(searchQuery) },
                onBackClick = {  }
            )
        }

        SearchTabs()
        SearchKeywordLayout()
        HorizontalDivider(thickness = 8.dp, color = CarrotTheme.colors.gray2)

        when (searchState) {
            is UiState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            is UiState.Success -> {
                val (products, similarProducts) = (searchState as UiState.Success<Pair<List<SearchProductModel>, List<SearchProductModel>>>).data

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    SearchFilterLayout(
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                ProductResultContent(
                    products = products,
                    similarProducts = similarProducts,
                    searchQuery = searchQuery,
                    onProductClick = { productId, userId ->
                        navController.navigate("${ScreenRoutes.PRODUCT_DETAIL}/$productId/$userId")
                    }
                )
            }

            is UiState.Empty -> {
                ProductResultContent(
                    products = emptyList(),
                    similarProducts = emptyList(),
                    searchQuery = searchQuery,
                    onProductClick = { productId, userId ->
                        navController.navigate("${ScreenRoutes.PRODUCT_DETAIL}/$productId/$userId")
                    }
                )
            }

            is UiState.Error -> {
                Text(
                    text = (searchState as UiState.Error).message ?: stringResource(R.string.search_screen_error),
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    style = CarrotTheme.typography.body.md_15
                )
            }
        }
    }
}
