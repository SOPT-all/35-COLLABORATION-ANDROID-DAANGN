package org.sopt.carrot.presentation.titleSearchScreen.components.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.carrot.R
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun SearchView(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    onSearch: () -> Unit,  // 추가
    onBackClick: () -> Unit,
    onCloseClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(42.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BackButton(onBackClick)
        Spacer(modifier = Modifier.width(12.dp))
        SearchField(
            searchQuery = searchQuery,
            onSearchQueryChange = onSearchQueryChange,
            onSearch = onSearch,  // 추가
            onCloseClick = onCloseClick,
            modifier = Modifier
        )
    }
}

@Composable
private fun BackButton(onBackClick: () -> Unit) {
    IconButton(onClick = onBackClick, modifier = Modifier.size(28.dp)) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_direction_left_black_28),
            contentDescription = "뒤로가기",
        )
    }
}

@Composable
private fun SearchField(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    onSearch: () -> Unit,
    onCloseClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    BasicTextField(
        value = searchQuery,
        onValueChange = { newValue ->
            if (newValue.contains("\n")) {
                onSearchQueryChange(newValue.replace("\n", ""))
                onSearch()
            } else {
                onSearchQueryChange(newValue)
            }
        },
        modifier = modifier.height(42.dp),
        textStyle = CarrotTheme.typography.body.md_18_03,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = { onSearch() }
        ),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = CarrotTheme.colors.gray2,
                        shape = RoundedCornerShape(6.dp)
                    )
                    .padding(start = 12.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                if (searchQuery.isEmpty()) {
                    Text(
                        text = stringResource(R.string.search_text_holder),
                        style = CarrotTheme.typography.body.md_18_03,
                        color = CarrotTheme.colors.gray5
                    )
                }
                innerTextField()
                if (searchQuery.isNotEmpty()) {
                    IconButton(
                        onClick = onCloseClick,
                        modifier = Modifier.align(Alignment.CenterEnd)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete_circle_18),
                            contentDescription = "지우기",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun SearchTabs() {
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.search_segmentedbar),
            contentDescription = "검색 탭바",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
    }
}

@Composable
fun SearchTopBar(
    searchQuery: String,
    onQueryChange: (String) -> Unit,
    onSearch: () -> Unit, // 엔터 키 이벤트를 처리할 콜백 추가
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(CarrotTheme.colors.white),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Spacer(modifier = Modifier.height(38.dp))
        SearchView(
            searchQuery = searchQuery,
            onSearchQueryChange = onQueryChange,
            onSearch = onSearch,
            onBackClick = onBackClick,
            onCloseClick = { onQueryChange("") }
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview
@Composable
private fun SearchTopBarPreview() {

    SearchTopBar(
        searchQuery = "",
        onSearch = {},
        onQueryChange = {},
        onBackClick = {}
    )

}
