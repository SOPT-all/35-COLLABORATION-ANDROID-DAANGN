package org.sopt.carrot.presentation.productDetailScreen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import org.sopt.carrot.presentation.ScreenRoutes
import org.sopt.carrot.presentation.productDetailScreen.components.KeywordAlertSection
import org.sopt.carrot.presentation.productDetailScreen.components.ProductBottomBar
import org.sopt.carrot.presentation.productDetailScreen.components.ProductImageSection
import org.sopt.carrot.presentation.productDetailScreen.components.ProductInfoSection
import org.sopt.carrot.presentation.productDetailScreen.components.ProductTopBar
import org.sopt.carrot.presentation.productDetailScreen.components.RecommendProductSection
import org.sopt.carrot.presentation.productDetailScreen.components.RelatedProductSection
import org.sopt.carrot.presentation.productDetailScreen.components.UserInfoSection
import org.sopt.carrot.presentation.productDetailScreen.model.ProductDetailUiState

@Composable
fun ProductDetailScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val onBackClick = { navController.navigate(ScreenRoutes.TITLE_SEARCH) }
    val onHomeClick = { navController.navigate((ScreenRoutes.EXAMPLE_SCREEN_1)) }
    val viewModel: ProductDetailViewModel = remember { ProductDetailViewModel() }
    val uiState: ProductDetailUiState by viewModel.uiState.collectAsStateWithLifecycle()

    val scrollState = rememberLazyListState()
    val isScrolledPastImage =
        scrollState.firstVisibleItemIndex > 0 || scrollState.firstVisibleItemScrollOffset > 0

    val backgroundColor by animateColorAsState(
        targetValue = if (isScrolledPastImage) Color.White else Color.Transparent,
        animationSpec = tween(durationMillis = 500),
        label = ""
    )

    Scaffold(
        topBar = {
            ProductTopBar(
                onBackClick = onBackClick,
                onHomeClick = onHomeClick,
                backgroundColor = backgroundColor,
                modifier = Modifier.zIndex(1f).background(backgroundColor)
            )
        },
        bottomBar = {
            if (uiState is ProductDetailUiState.Success) {
                ProductBottomBar(
                    onLikeClick = {},
                    productPrice = (uiState as ProductDetailUiState.Success).productInfo.price
                )
            }
        }
    ) { paddingValues ->
        when (uiState) {
            is ProductDetailUiState.Success -> {
                val state = uiState as ProductDetailUiState.Success
                LazyColumn(
                    state = scrollState,
                    contentPadding = PaddingValues(bottom = paddingValues.calculateBottomPadding()),
                    modifier = modifier
                        .fillMaxSize()
                        .zIndex(0f)
                        .background(color = Color.White)
                ) {
                    item { ProductImageSection(productImage = state.productInfo.productImage) }

                    item {
                        UserInfoSection(
                            userInfo = state.userInfo,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                    }

                    item {
                        ProductInfoSection(
                            productInfo = state.productInfo,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                    }
                    item {
                        RelatedProductSection(
                            userInfo = state.userInfo,
                            relatedProducts = state.relatedProducts,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                    }
                    item {
                        KeywordAlertSection(
                            productTitle = state.productInfo.title,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                    }
                    item {
                        RecommendProductSection(modifier = Modifier.padding(horizontal = 16.dp))
                    }
                }
            }

            ProductDetailUiState.Loading -> LoadingScreen()
            ProductDetailUiState.Error -> ErrorScreen()
        }
    }
}

@Composable
private fun LoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun ErrorScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "에러가 발생했습니다.")
    }
}
