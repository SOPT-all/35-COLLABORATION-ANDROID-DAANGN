package org.sopt.carrot.presentation.productDetailScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.jetbrains.annotations.VisibleForTesting
import org.sopt.carrot.data.model.response.ProductInfo
import org.sopt.carrot.data.model.response.RelatedProduct
import org.sopt.carrot.data.model.response.UserInfo
import org.sopt.carrot.presentation.productDetailScreen.model.ProductDetailUiState
import org.sopt.carrot.presentation.productDetailScreen.model.ProductUiState
import org.sopt.carrot.presentation.productDetailScreen.model.RelatedProductUiState
import org.sopt.carrot.presentation.productDetailScreen.model.UserUiState

class ProductDetailViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<ProductDetailUiState>(ProductDetailUiState.Loading)
    val uiState: StateFlow<ProductDetailUiState> = _uiState.asStateFlow()

    init {
        fetchProductDetail()
    }

    private fun fetchProductDetail() {
        // Mock data for now
        val mockUserInfo = UserInfo(
            userId = 1,
            nickname = "뷰모델",
            profileImage = "",
            address = "송파구 삼정동"
        )

        val mockProductInfo = ProductInfo(
            productId = 1,
            productImage = "",
            title = "렉토 맨투맨",
            category = "여성 의류",
            content = "이거 뷰모델에 넣어놓은 데이터임\n줄줄이 적어도 잘 나옴\n후후후",
            price = "10,000",
            view = 5
        )

        val mockRelatedProducts = listOf(
            RelatedProduct(
                id = 1,
                productImage = "~~~~",
                title = "이거 뷰모델에 있는거임, 그 유저가 파는 상품 보여줌",
                price = "24,000"
            ),
            RelatedProduct(
                id = 2,
                productImage = "~~~~",
                title = "이거 뷰모델에 있는거임, 그 유저가 파는 상품 보여줌",
                price = "24,000"
            ),
            RelatedProduct(
                id = 3,
                productImage = "~~~~",
                title = "이거 뷰모델에 있는거임, 그 유저가 파는 상품 보여줌",
                price = "24,000"
            ),
            RelatedProduct(
                id = 4,
                productImage = "~~~~",
                title = "이거 뷰모델에 있는거임, 그 유저가 파는 상품 보여줌",
                price = "24,000"
            )
        )

        updateUiState(
            mockUserInfo.toUiState(),
            mockProductInfo.toUiState(),
            mockRelatedProducts.map { it.toUiState() }
        )
    }

    private fun updateUiState(
        userInfo: UserUiState,
        productInfo: ProductUiState,
        relatedProducts: List<RelatedProductUiState>
    ) {
        _uiState.update {
            ProductDetailUiState.Success(
                userInfo = userInfo,
                productInfo = productInfo,
                relatedProducts = relatedProducts
            )
        }
    }
}

private fun UserInfo.toUiState() = UserUiState(
    nickname = nickname,
    profileImage = profileImage,
    address = address
)

private fun ProductInfo.toUiState() = ProductUiState(
    productImage = productImage,
    title = title,
    category = category,
    content = content,
    price = price,
    view = view
)

private fun RelatedProduct.toUiState() = RelatedProductUiState(
    productImage = productImage,
    title = title,
    price = price
)


