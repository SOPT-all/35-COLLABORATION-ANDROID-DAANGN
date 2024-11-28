package org.sopt.carrot.presentation.titleSearchScreen.components.product

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.carrot.R
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun ErrorContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.error_search_result),
            style = CarrotTheme.typography.body.md_14_03,
            color = CarrotTheme.colors.gray6,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun ErrorContentPreview() {
    ErrorContent()
}
