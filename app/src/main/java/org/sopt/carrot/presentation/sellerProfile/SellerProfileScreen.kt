package org.sopt.carrot.presentation.sellerProfile

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SellerProfileScreen() {
    Scaffold(
        topBar = {},
        bottomBar = {},
        content = { innerPadding ->
            SellerProfileContent(
                modifier = Modifier.padding(innerPadding)
            )
        }
    )
}

@Composable
private fun SellerProfileContent(
    modifier: Modifier = Modifier
) {

}

@Preview
@Composable
private fun PreviewSellerProfileScreen() {
    SellerProfileScreen()
}
