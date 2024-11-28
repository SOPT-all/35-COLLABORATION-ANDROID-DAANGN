package org.sopt.carrot.presentation.productDetailScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.carrot.R

@Composable
fun ProductImageSection(
    productImage: String,
    modifier: Modifier = Modifier
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    Box(
        modifier = modifier
            .fillMaxWidth()
            .size(screenWidth)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_details),
            contentDescription = "상품 이미지",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
//        AsyncImage(
//            model = productImage,
//            contentDescription = "상품 이미지",
//            contentScale = ContentScale.Crop,
//            modifier = Modifier.fillMaxSize()
//        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductImageSectionPreview() {
    ProductImageSection(
        productImage = "https://example.com/images/product1.jpg"
    )
}