package org.sopt.carrot.presentation.ExampleScreen1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.testing.TestNavHostController
import org.sopt.carrot.core.common.ViewModelFactory
import org.sopt.carrot.presentation.ScreenRoutes
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun ExampleScreen1(navController: NavController) {
    val viewModel: ExampleScreen1ViewModel = viewModel(factory = ViewModelFactory())

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "첫번째 스크린")
        Button(
            onClick = { navController.navigate(ScreenRoutes.EXAMPLE_SCREEN_2) } // 화면 전환
        ) {
            Text("2번째 스크린으로")
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "안녕하세요. title.b_25 입니다.", style = CarrotTheme.typography.title.b_25)
        Text(text = "안녕하세요. title.extb_24_1 입니다.", style = CarrotTheme.typography.title.extb_24_1)
        Text(text = "안녕하세요. title.b_22_044 입니다.", style = CarrotTheme.typography.title.b_22_044)
        Text(text = "안녕하세요. title.b_20_04 입니다.", style = CarrotTheme.typography.title.b_20_04)
        Text(text = "안녕하세요. body.b_18 입니다.", style = CarrotTheme.typography.body.b_18)
        Text(text = "안녕하세요. body.b_18_072 입니다.", style = CarrotTheme.typography.body.b_18_072)
        Text(text = "안녕하세요. body.b_18_144 입니다.", style = CarrotTheme.typography.body.b_18_144)
        Text(text = "안녕하세요. body.md_18_03 입니다.", style = CarrotTheme.typography.body.md_18_03)
        Text(text = "안녕하세요. body.b_17 입니다.", style = CarrotTheme.typography.body.b_17)
        Text(text = "안녕하세요. body.sb_17_08 입니다.", style = CarrotTheme.typography.body.sb_17_08)
        Text(text = "안녕하세요. body.md_17 입니다.", style = CarrotTheme.typography.body.md_17)
        Text(text = "안녕하세요. body.md_17_017 입니다.", style = CarrotTheme.typography.body.md_17_017)
        Text(text = "안녕하세요. body.b_16_07 입니다.", style = CarrotTheme.typography.body.b_16_07)
        Text(text = "안녕하세요. body.b_16_08 입니다.", style = CarrotTheme.typography.body.b_16_08)
        Text(text = "안녕하세요. body.md_16_07 입니다.", style = CarrotTheme.typography.body.md_16_07)
        Text(text = "안녕하세요. body.extb_15 입니다.", style = CarrotTheme.typography.body.extb_15)
        Text(text = "안녕하세요. body.bla_15_03 입니다.", style = CarrotTheme.typography.body.bla_15_03)
        Text(text = "안녕하세요. body.bla_15_06 입니다.", style = CarrotTheme.typography.body.bla_15_06)
        Text(text = "안녕하세요. body.md_15 입니다.", style = CarrotTheme.typography.body.md_15)
        Text(text = "안녕하세요. body.md_15_05 입니다.", style = CarrotTheme.typography.body.md_15_05)
        Text(text = "안녕하세요. body.b_14 입니다.", style = CarrotTheme.typography.body.b_14)
        Text(text = "안녕하세요. body.sb_14 입니다.", style = CarrotTheme.typography.body.sb_14)
        Text(text = "안녕하세요. body.sb_14_22_028 입니다.", style = CarrotTheme.typography.body.sb_14_22_028)
        Text(text = "안녕하세요. body.md_14 입니다.", style = CarrotTheme.typography.body.md_14)
        Text(text = "안녕하세요. body.md_14_20_0 입니다.", style = CarrotTheme.typography.body.md_14_20_0)
        Text(text = "안녕하세요. body.md_14_03 입니다.", style = CarrotTheme.typography.body.md_14_03)
        Text(text = "안녕하세요. body.md_14_028 입니다.", style = CarrotTheme.typography.body.md_14_028)
        Text(text = "안녕하세요. body.r_14 입니다.", style = CarrotTheme.typography.body.r_14)
        Text(text = "안녕하세요. body.md_13_18_013 입니다.", style = CarrotTheme.typography.body.md_13_18_013)
        Text(text = "안녕하세요. caption.md_14_028 입니다.", style = CarrotTheme.typography.caption.md_14_028)
        Text(text = "안녕하세요. caption.r_13 입니다.", style = CarrotTheme.typography.caption.r_13)
        Text(text = "안녕하세요. caption.md_12 입니다.", style = CarrotTheme.typography.caption.md_12)
        Text(text = "안녕하세요. caption.b_11 입니다.", style = CarrotTheme.typography.caption.b_11)
        Text(text = "안녕하세요. caption.md_11 입니다.", style = CarrotTheme.typography.caption.md_11)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewExampleScreen1() {
    val navController = TestNavHostController(LocalContext.current)
    ExampleScreen1(navController = navController)
}
