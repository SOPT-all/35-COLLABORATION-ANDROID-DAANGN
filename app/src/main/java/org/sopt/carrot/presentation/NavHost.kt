package org.sopt.carrot.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import org.sopt.carrot.presentation.ExampleScreen1.ExampleScreen1
import org.sopt.carrot.presentation.ExampleScreen2.ExampleScreen2
import org.sopt.carrot.presentation.titleSearchScreen.TitleSearchScreen
import org.sopt.carrot.presentation.category.CategoryScreen
import org.sopt.carrot.presentation.productDetailScreen.ProductDetailScreen

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = "example_screen_1",
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

        composable(ScreenRoutes.EXAMPLE_SCREEN_1) { ExampleScreen1(navController) }
        composable(ScreenRoutes.EXAMPLE_SCREEN_2) { ExampleScreen2(navController) }

        composable(ScreenRoutes.CATEGORY_SCREEN) {
            CategoryScreen(
                onBackClick = { navController.popBackStack() },
                navigateToHome = { navController.navigate(ScreenRoutes.EXAMPLE_SCREEN_2) }
            )
        }
    }
}
