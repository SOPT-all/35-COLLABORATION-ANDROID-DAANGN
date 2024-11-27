package org.sopt.carrot.presentation.productDetailScreen.model

sealed interface ProductDetailUiState {
    data object Loading : ProductDetailUiState
    data object Error : ProductDetailUiState
    data class Success(
        val userInfo: UiUserInfoDto,
        val productInfo: UiProductInfoDto,
        val relatedProducts: List<UiRelatedProductDto>
    ) : ProductDetailUiState
}

data class UiUserInfoDto(
    val nickname: String = "",
    val profileImage: String = "",
    val address: String = ""
)

data class UiProductInfoDto(
    val productImage: String = "",
    val title: String = "",
    val category: String = "",
    val content: String = "",
    val price: String = "",
    val view: Int = 0
)

data class UiRelatedProductDto(
    val productImage: String = "",
    val title: String = "",
    val price: String = ""
)
