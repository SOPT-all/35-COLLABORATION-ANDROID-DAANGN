package org.sopt.carrot.presentation.main.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import org.sopt.carrot.R

@Composable
fun MainFloatingButton(
    listState: LazyListState,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val iconResId = if (listState.firstVisibleItemIndex == 0) {
        R.drawable.ic_home_fab_icontext
    } else {
        R.drawable.ic_home_fab_icon
    }

    Icon(
        painter = painterResource(id = iconResId),
        contentDescription = null,
        modifier = modifier
            .clickable { onClick() },
        tint = Color.Unspecified
    )
}
