package org.sopt.carrot.presentation.productDetailScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.sopt.carrot.data.model.response.ResponseProductInfoDto
import org.sopt.carrot.data.model.response.ResponseRelatedProductDto
import org.sopt.carrot.data.model.response.ResponseUserInfoDto
import org.sopt.carrot.presentation.productDetailScreen.model.ProductDetailUiState
import org.sopt.carrot.presentation.productDetailScreen.model.UiProductInfoDto
import org.sopt.carrot.presentation.productDetailScreen.model.UiRelatedProductDto
import org.sopt.carrot.presentation.productDetailScreen.model.UiUserInfoDto

class ProductDetailViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<ProductDetailUiState>(ProductDetailUiState.Loading)
    val uiState: StateFlow<ProductDetailUiState> = _uiState.asStateFlow()

    init {
        fetchProductDetail()
    }

    private fun fetchProductDetail() {
        // Mock data for now
        val mockUserInfo = ResponseUserInfoDto(
            userId = 1,
            nickname = "뷰모델",
            profileImage = "",
            address = "송파구 삼정동"
        )

        val mockProductInfo = ResponseProductInfoDto(
            productId = 1,
            productImage = "",
            title = "렉토 맨투맨",
            category = "여성 의류",
            content = "이거 뷰모델에 넣어놓은 데이터임\n줄줄이 적어도 잘 나옴\n후후후",
            price = "10,000",
            view = 5
        )

        val mockRelatedProducts = listOf(
            ResponseRelatedProductDto(
                id = 1,
                productImage = "~~~~",
                title = "이거 뷰모델에 있는거임, 그 유저가 파는 상품 보여줌",
                price = "24,000"
            ),
            ResponseRelatedProductDto(
                id = 2,
                productImage = "~~~~",
                title = "이거 뷰모델에 있는거임, 그 유저가 파는 상품 보여줌",
                price = "24,000"
            ),
            ResponseRelatedProductDto(
                id = 3,
                productImage = "~~~~",
                title = "이거 뷰모델에 있는거임, 그 유저가 파는 상품 보여줌",
                price = "24,000"
            ),
            ResponseRelatedProductDto(
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
        userInfo: UiUserInfoDto,
        productInfo: UiProductInfoDto,
        relatedProducts: List<UiRelatedProductDto>
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

private fun ResponseUserInfoDto.toUiState() = UiUserInfoDto(
    nickname = nickname,
    profileImage = profileImage,
    address = address
)

private fun ResponseProductInfoDto.toUiState() = UiProductInfoDto(
    productImage = productImage,
    title = title,
    category = category,
    content = content,
    price = price,
    view = view
)

private fun ResponseRelatedProductDto.toUiState() = UiRelatedProductDto(
    productImage = productImage,
    title = title,
    price = price
)
