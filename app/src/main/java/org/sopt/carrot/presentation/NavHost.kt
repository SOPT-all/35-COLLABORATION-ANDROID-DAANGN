package org.sopt.carrot.presentation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navArgument
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.sopt.carrot.presentation.ExampleScreen1.ExampleScreen1
import org.sopt.carrot.presentation.ExampleScreen2.ExampleScreen2
import org.sopt.carrot.presentation.titleSearchScreen.TitleSearchScreen
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

        composable(ScreenRoutes.EXAMPLE_SCREEN_1) { ExampleScreen1(navController) }
        composable(ScreenRoutes.EXAMPLE_SCREEN_2) { ExampleScreen2(navController) }

        /* 이런식으로 사용하면 됩니다!
        composable(
            route = "${ScreenRoutes.EXAMPLE_SCREEN_2}/{json}",
            arguments = listOf(
                navArgument("json") {
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) { backStackEntry ->
            val json = backStackEntry.arguments?.getString("json")
            val selectedCategories: List<String> = json?.let {
                Json.decodeFromString(it)
            } ?: emptyList()
            ExampleScreen2(navController, selectedCategories)
        }
        */

        composable(route = ScreenRoutes.CATEGORY_SCREEN) {
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
