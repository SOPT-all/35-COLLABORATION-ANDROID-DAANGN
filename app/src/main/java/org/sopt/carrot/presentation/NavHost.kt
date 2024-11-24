package org.sopt.carrot.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.sopt.carrot.presentation.ExampleScreen1.ExampleScreen1
import org.sopt.carrot.presentation.ExampleScreen2.ExampleScreen2
import org.sopt.carrot.presentation.main.MainScreen
import org.sopt.carrot.presentation.titleSearchScreen.TitleSearchScreen
import org.sopt.carrot.presentation.category.CategoryScreen
import org.sopt.carrot.presentation.main.MainScreen

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.MAIN_SCREEN,
        modifier = modifier
    ) {
        composable(ScreenRoutes.TITLE_SEARCH) {
            TitleSearchScreen(
                onBackClick = { navController.popBackStack() },
                onProductClick = { productId ->
                    navController.navigate(ScreenRoutes.EXAMPLE_SCREEN_2)
                }
            )
        }
        composable(ScreenRoutes.EXAMPLE_SCREEN_1) { ExampleScreen1(navController) }
        composable(ScreenRoutes.EXAMPLE_SCREEN_2) { ExampleScreen2(navController) }
        composable(ScreenRoutes.MAIN_SCREEN) { MainScreen(navController) }

        composable(ScreenRoutes.MAIN_SCREEN) { MainScreen(navController) }


        composable(ScreenRoutes.CATEGORY_SCREEN) {
            CategoryScreen(
                onBackClick = { navController.popBackStack() },
                navigateToHome = { navController.navigate(ScreenRoutes.EXAMPLE_SCREEN_2) }
            )
        }
    }
}
