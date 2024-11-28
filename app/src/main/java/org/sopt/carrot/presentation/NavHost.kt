package org.sopt.carrot.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import org.sopt.carrot.presentation.category.CategoryScreen
import org.sopt.carrot.presentation.main.MainScreen
import org.sopt.carrot.presentation.productDetailScreen.ProductDetailScreen
import org.sopt.carrot.presentation.sellerProfile.SellerProfileScreen
import org.sopt.carrot.presentation.titleSearchScreen.TitleSearchScreen

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.MAIN_SCREEN,
        modifier = modifier
    ) {
        composable(ScreenRoutes.TITLE_SEARCH) {
            TitleSearchScreen(navController)
        }
        composable(
            route = ScreenRoutes.PRODUCT_DETAIL_WITH_ARGS,
            arguments = listOf(
                navArgument("productId") { type = NavType.LongType },
                navArgument("userId") { type = NavType.LongType }
            )
        ) {
            ProductDetailScreen(navController)
        }
        composable(ScreenRoutes.PRODUCT_DETAIL) { ProductDetailScreen(navController) }
        composable(ScreenRoutes.MAIN_SCREEN) { MainScreen(navController) }
        composable(ScreenRoutes.CATEGORY_SCREEN) {
            CategoryScreen(
                onBackClick = { navController.popBackStack() },
                navigateToHome = { navController.navigate(ScreenRoutes.EXAMPLE_SCREEN_2) }
            )
        }
        composable(ScreenRoutes.SELLER_PROFILE_SCREEN) {
            SellerProfileScreen()
        }
    }
}
