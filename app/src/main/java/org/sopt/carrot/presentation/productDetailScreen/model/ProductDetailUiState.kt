package org.sopt.carrot.presentation.productDetailScreen.model

sealed interface ProductDetailUiState {
    data object Loading : ProductDetailUiState
    data object Error : ProductDetailUiState
    data class Success(
        val userInfo: UserUiState,
        val productInfo: ProductUiState,
        val relatedProducts: List<RelatedProductUiState>
    ) : ProductDetailUiState
}

data class UserUiState(
    val nickname: String = "",
    val profileImage: String = "",
    val address: String = ""
)

data class ProductUiState(
    val productImage: String = "",
    val title: String = "",
    val category: String = "",
    val content: String = "",
    val price: String = "",
    val view: Int = 0
)

data class RelatedProductUiState(
    val productImage: String = "",
    val title: String = "",
    val price: String = ""
)
