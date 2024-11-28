package org.sopt.carrot.presentation.category

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.carrot.R
import org.sopt.carrot.core.common.ViewModelFactory
import org.sopt.carrot.presentation.category.component.CategoryBottomBar
import org.sopt.carrot.presentation.category.component.CategoryTopBar
import org.sopt.carrot.presentation.category.component.section.CategorySelection
import org.sopt.carrot.presentation.category.component.section.FilterTabs
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun CategoryScreen(
    onBackClick: () -> Unit = {},
    navigateToHome: (List<String>) -> Unit = {},
    viewmodel: CategoryViewmodel = viewModel(factory = ViewModelFactory()),
) {
    LaunchedEffect(Unit) {
        viewmodel.fetchCategory()
    }

    val categories = viewmodel.categories
    val selectedCategories = viewmodel.selectedCategories

    Scaffold(
        topBar = {
            CategoryTopBar(
                onBackClick = onBackClick
            )
        },
        bottomBar = {
            CategoryBottomBar(
                isEnabled = viewmodel.check(),
                onClearSelectedCategories = { viewmodel.clearSelectedCategories() },
                onApplyCategories = { navigateToHome(selectedCategories) }
            )
        },
        containerColor = CarrotTheme.colors.white,
        content = { paddingValues ->
            CategoryContent(
                modifier = Modifier.padding(paddingValues),
                categories = categories,
                onCheckedChange = { category ->
                    viewmodel.toggleCategoryProcess(category)
                },
            )
        }
    )
}

@Composable
private fun CategoryContent(
    modifier: Modifier,
    categories: Map<String, Boolean>,
    onCheckedChange: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 24.dp)
    ) {
        Text(
            text = stringResource(R.string.category_filter_title),
            style = CarrotTheme.typography.title.b_25,
            modifier = Modifier.padding(start = 16.dp),
        )

        Spacer(modifier = Modifier.height(13.dp))

        FilterTabs()

        CategorySelection(
            categories = categories,
            onCheckedChange = onCheckedChange
        )
    }
}

@Preview
@Composable
private fun PreviewCategoryScreen() {
    CategoryScreen()
}
