package org.sopt.carrot.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.testing.TestNavHostController
import org.sopt.carrot.R
import org.sopt.carrot.core.common.ViewModelFactory
import org.sopt.carrot.core.extension.noRippleClickable
import org.sopt.carrot.presentation.ScreenRoutes
import org.sopt.carrot.presentation.main.component.FilterChipButton
import org.sopt.carrot.presentation.main.component.MainFloatingButton
import org.sopt.carrot.presentation.main.component.ProductList
import org.sopt.carrot.presentation.main.component.TagChipButton
import org.sopt.carrot.presentation.util.UiState
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun MainScreen(navController: NavController) {
    val listState = rememberLazyListState()
    val viewModel: MainViewModel = viewModel(factory = ViewModelFactory())
    val uiState by viewModel.product.collectAsState()

    val tagList = remember { mutableStateListOf<String>() }

    LaunchedEffect(Unit) {
        tagList.clear()
        tagList.addAll(
            navController.previousBackStackEntry?.savedStateHandle?.get<List<String>>("selectedCategories")
                ?: emptyList()
        )
        viewModel.setCategory(if (tagList.isEmpty()) null else tagList)
        viewModel.getHomeProduct()
    }

    LaunchedEffect(tagList.size) {
        if (tagList.isEmpty()) {
            viewModel.setCategory(null)
            viewModel.getHomeProduct()
        }
    }

    LaunchedEffect(uiState) {
        if (uiState is UiState.Success) {
            listState.scrollToItem(0)
        }
    }

    val updatedProducts = remember(uiState) {
        if (uiState is UiState.Success) {
            addRandomDataToProducts((uiState as UiState.Success).data)
        } else {
            emptyList()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 56.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            MainTopBar(navController, onSearchClick = {
                navController.navigate(ScreenRoutes.TITLE_SEARCH)
            })

            ScrollableFilterBar(navController)

            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                when (uiState) {
                    is UiState.Loading -> {
                    }

                    is UiState.Error -> {
                        Text(
                            text = "Error: ${(uiState as UiState.Error).message}",
                            color = Color.Red,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }

                    is UiState.Success -> {
                        Column {
                            if (tagList.isNotEmpty()) {
                                MainTagBar(
                                    tagList = tagList,
                                    onRemoveTag = { tag -> tagList.remove(tag) }
                                )
                            }
                            ProductList(items = updatedProducts, listState = listState)
                        }
                    }

                    else -> Unit
                }
            }
        }

        MainBottomBar(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )

        MainFloatingButton(
            listState = listState,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 86.dp),
            onClick = {}
        )
    }
}

@Composable
fun MainTopBar(
    navController: NavController,
    modifier: Modifier = Modifier,
    onSearchClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 44.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("가락2동", style = CarrotTheme.typography.title.extb_24_1)
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_direction_down_18),
                contentDescription = ""
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search_28),
                contentDescription = stringResource(R.string.main_search_icon),
                modifier.noRippleClickable {
                    onSearchClick()
                }
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_menu_hamburger_28),
                contentDescription = stringResource(R.string.main_hamburger_icon)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_notification_lg_28),
                contentDescription = stringResource(R.string.main_notification_icon),
                tint = Color.Unspecified
            )
        }
    }
}

@Composable
fun ScrollableFilterBar(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            painter = painterResource(id = R.drawable.ic_reset_18),
            contentDescription = stringResource(R.string.main_reset_icon),
            modifier = Modifier
                .padding(end = 8.dp)
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = CircleShape
                )
                .padding(8.dp)
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(listOf("가락2동 외 59", "가격", "카테고리", "정확도순")) { filterText ->
                FilterChipButton(text = filterText,
                    onClick = {
                        if (filterText == "카테고리") {
                            navController.navigate(ScreenRoutes.CATEGORY_SCREEN)
                        }
                    })
            }
        }

    }
}


@Composable
fun MainTagBar(
    tagList: List<String>, onRemoveTag: (String) -> Unit
) {
    Spacer(modifier = Modifier.padding(top = 12.dp))
    if (tagList.isNotEmpty()) {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .background(color = CarrotTheme.colors.gray3)
                .padding(vertical = 10.dp)
                .padding(start = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            tagList.forEach { filterText ->
                TagChipButton(
                    text = filterText,
                    onRemoveClick = { onRemoveTag(filterText) }
                )
            }
        }
    }
}

@Composable
fun MainBottomBar(modifier: Modifier = Modifier) {
    val aspectRatio = 412f / 58f

    Row(
        modifier
            .fillMaxWidth()
            .aspectRatio(aspectRatio)
            .background(Color.White)
    ) {
        Row(
            modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_bottombar_home_28),
                    contentDescription = stringResource(R.string.main_bottom_home),
                    tint = CarrotTheme.colors.gray8,
                )
                Text(
                    text = stringResource(R.string.main_bottom_home),
                    style = CarrotTheme.typography.caption.md_11,
                    color = CarrotTheme.colors.gray8
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_bottombar_life_28),
                    contentDescription = stringResource(R.string.main_bottom_life),
                )
                Text(
                    text = stringResource(R.string.main_bottom_life),
                    style = CarrotTheme.typography.caption.md_11,
                    color = CarrotTheme.colors.gray8
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_bottombar_map_28),
                    contentDescription = stringResource(R.string.main_bottom_map),
                )
                Text(
                    text = stringResource(R.string.main_bottom_map),
                    style = CarrotTheme.typography.caption.md_11,
                    color = CarrotTheme.colors.gray8
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_bottombar_chat_28),
                    contentDescription = stringResource(R.string.main_bottom_chat),
                )
                Text(
                    text = stringResource(R.string.main_bottom_chat),
                    style = CarrotTheme.typography.caption.md_11,
                    color = CarrotTheme.colors.gray8
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_bottombar_mypage_28),
                    contentDescription = stringResource(R.string.main_bottom_mypage),
                )
                Text(
                    text = stringResource(R.string.main_bottom_mypage),
                    style = CarrotTheme.typography.caption.md_11,
                    color = CarrotTheme.colors.gray8
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewExampleScreen1() {
    val navController = TestNavHostController(LocalContext.current)
//    MainScreen(navController = navController)
}
