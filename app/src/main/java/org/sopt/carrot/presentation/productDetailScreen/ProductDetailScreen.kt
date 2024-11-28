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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.sopt.carrot.R
import org.sopt.carrot.core.common.ViewModelFactory
import org.sopt.carrot.presentation.ScreenRoutes
import org.sopt.carrot.presentation.productDetailScreen.components.KeywordAlertSection
import org.sopt.carrot.presentation.productDetailScreen.components.ProductBottomBar
import org.sopt.carrot.presentation.productDetailScreen.components.ProductImageSection
import org.sopt.carrot.presentation.productDetailScreen.components.ProductInfoSection
import org.sopt.carrot.presentation.productDetailScreen.components.ProductTopBar
import org.sopt.carrot.presentation.productDetailScreen.components.RecommendProductSection
import org.sopt.carrot.presentation.productDetailScreen.components.RelatedProductSection
import org.sopt.carrot.presentation.productDetailScreen.components.UserInfoSection
import org.sopt.carrot.presentation.util.UiState
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun ProductDetailScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val onBackClick: () -> Unit = { navController.popBackStack() }
    val onHomeClick = { navController.navigate(ScreenRoutes.EXAMPLE_SCREEN_1) }

    val viewModel: ProductDetailViewModel = viewModel(factory = ViewModelFactory())
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val productId = remember {
        navController.currentBackStackEntry?.arguments?.getLong("productId")
            ?: throw IllegalStateException("productId is required")
    }
    val userId = remember {
        navController.currentBackStackEntry?.arguments?.getLong("userId")
            ?: throw IllegalStateException("userId is required")
    }

    LaunchedEffect(productId, userId) {
        viewModel.fetchProductDetail(productId, userId)
    }

    val scrollState = rememberLazyListState()
    val isScrolledPastImage =
        scrollState.firstVisibleItemIndex > 0 || scrollState.firstVisibleItemScrollOffset > 0

    val backgroundColor by animateColorAsState(
        targetValue = if (isScrolledPastImage) Color.White else Color.White.copy(alpha = 0f),
        animationSpec = tween(durationMillis = 800),
        label = ""
    )

    Scaffold(
        topBar = {
            ProductTopBar(
                onBackClick = onBackClick,
                onHomeClick = onHomeClick,
                backgroundColor = backgroundColor,
                modifier = Modifier
                    .zIndex(1f)
                    .background(backgroundColor)
            )
        },
        bottomBar = {
            if (uiState is UiState.Success) {
                val state = (uiState as UiState.Success<ProductDetailViewModel.DetailState>).data
                ProductBottomBar(
                    onLikeClick = {},
                    productPrice = state.productInfo.price
                )
            }
        }
    ) { paddingValues ->
        when (uiState) {
            is UiState.Loading -> LoadingScreen()

            is UiState.Success -> {
                val state = (uiState as UiState.Success<ProductDetailViewModel.DetailState>).data
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
                            productTitle = state.productInfo.title ?: "",
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                    }

                    item {
                        RecommendProductSection(modifier = Modifier.padding(horizontal = 16.dp))
                    }
                }
            }

            is UiState.Error -> ErrorScreen()

            else -> {}
        }
    }
}

@Composable
private fun ErrorScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(stringResource(R.string.product_info_error_screen))
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(color = CarrotTheme.colors.orange2)
    }
}


@Preview(showBackground = true)
@Composable
private fun ProductDetailScreenPreview() {
    val mockNavController = rememberNavController()
    ProductDetailScreen(
        navController = mockNavController
    )
}
