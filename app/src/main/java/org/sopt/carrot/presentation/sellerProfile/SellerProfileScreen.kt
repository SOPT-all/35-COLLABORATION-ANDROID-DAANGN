package org.sopt.carrot.presentation.sellerProfile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.sopt.carrot.core.common.ViewModelFactory
import org.sopt.carrot.domain.model.UserDetail
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
fun SellerProfileScreen(
    navController: NavHostController,
    viewmodel: SellerProfileViewmodel = viewModel(factory = ViewModelFactory())
) {

    var isDialogVisible by remember { mutableStateOf(false) }

    val userId = remember {
        navController.currentBackStackEntry?.arguments?.getLong("userId")
            ?: throw IllegalStateException("userId is required")
    }

    LaunchedEffect(userId) {
        viewmodel.fetchSellerProfile(userId)
    }

    val sellerProfile by viewmodel.sellerProfile.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(CarrotTheme.colors.white)
    ) {
        SellerProfileTopBar(
            onBackClick = { navController.popBackStack() },
            onShareClick = {},
            onMenuClick = {}
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .zIndex(1f)
        ) {
            if (isDialogVisible) {
                SellerFollowDialog(
                    onClickCancel = { isDialogVisible = false }
                )
            }

            sellerProfile?.let { profile ->
                SellerProfileContent(
                    onFollowClick = { isDialogVisible = true },
                    sellerProfile = profile
                )
            }
        }
    }
}

@Composable
private fun SellerProfileContent(
    onFollowClick: () -> Unit,
    sellerProfile: UserDetail
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            SellerProfileSection(
                onFollowClick = onFollowClick,
                sellerProfile = sellerProfile
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
    val mockNavController = rememberNavController()
    SellerProfileScreen(
        navController = mockNavController
    )
}
