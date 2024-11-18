package org.sopt.carrot.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.sopt.carrot.presentation.ExampleScreen1.ExampleScreen1
import org.sopt.carrot.presentation.ExampleScreen2.ExampleScreen2

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = "example_screen_1",
        modifier = modifier
    ) {
        composable(ScreenRoutes.EXAMPLE_SCREEN_1) { ExampleScreen1(navController) }
        composable(ScreenRoutes.EXAMPLE_SCREEN_2) { ExampleScreen2(navController) }
    }
}
