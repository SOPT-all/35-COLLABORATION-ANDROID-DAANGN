package org.sopt.carrot.presentation.sellerProfile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.carrot.presentation.sellerProfile.component.SellerFollowDialog
import org.sopt.carrot.presentation.sellerProfile.component.SellerProfileTopBar
import org.sopt.carrot.presentation.sellerProfile.component.section.BadgeSection
import org.sopt.carrot.presentation.sellerProfile.component.section.LocationSection
import org.sopt.carrot.presentation.sellerProfile.component.section.MannerSection
import org.sopt.carrot.presentation.sellerProfile.component.section.ReviewSection
import org.sopt.carrot.presentation.sellerProfile.component.section.SaleProductSection
import org.sopt.carrot.presentation.sellerProfile.component.section.SellerProfileSection
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun SellerProfileScreen() {

    var isDialogVisible by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            SellerProfileTopBar(
                onBackClick = {},
                onShareClick = {},
                onMenuClick = {}
            )
        },
        contentColor = CarrotTheme.colors.gray1,
        content = { innerPadding ->
            Box(modifier = Modifier.fillMaxSize()) {
                SellerProfileContent(
                    modifier = Modifier.padding(innerPadding),
                    onFollowClick = { isDialogVisible = true }
                )

                if (isDialogVisible) {
                    SellerFollowDialog(
                        onClickCancel = { isDialogVisible = false }
                    )
                }
            }
        }
    )
}

@Composable
private fun SellerProfileContent(
    modifier: Modifier,
    onFollowClick: () -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        item {
            SellerProfileSection(
                onFollowClick = onFollowClick
            )
        }
        item { LocationSection() }
        item { BadgeSection() }
        item {
            HorizontalDivider(
                color = CarrotTheme.colors.gray3,
                thickness = 1.dp
            )
        }
        item { SaleProductSection() }
        item {
            HorizontalDivider(
                color = CarrotTheme.colors.gray3,
                thickness = 1.dp
            )
        }
        item { MannerSection() }
        item {
            HorizontalDivider(
                color = CarrotTheme.colors.gray3,
                thickness = 1.dp
            )
        }
        item { ReviewSection() }
    }
}

@Preview
@Composable
private fun PreviewSellerProfileScreen() {
    SellerProfileScreen()
}
