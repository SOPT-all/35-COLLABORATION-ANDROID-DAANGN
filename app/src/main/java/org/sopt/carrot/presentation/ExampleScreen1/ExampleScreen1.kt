package org.sopt.carrot.presentation.ExampleScreen1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.testing.TestNavHostController
import org.sopt.carrot.presentation.ScreenRoutes

@Composable
fun ExampleScreen1(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "첫번째 스크린")
        Button(
            onClick = { navController.navigate(ScreenRoutes.EXAMPLE_SCREEN_2) } // 화면 전환
        ) {
            Text("2번째 스크린으로")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewExampleScreen1() {
    val navController = TestNavHostController(LocalContext.current)
    ExampleScreen1(navController = navController)
}