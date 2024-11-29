package org.sopt.carrot.presentation.productDetailScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.carrot.domain.model.ProductDetailInfo
import org.sopt.carrot.domain.repository.ProductDetailRepository
import org.sopt.carrot.domain.repository.UserRepository
import org.sopt.carrot.presentation.util.UiState

class ProductDetailViewModel(
    private val productRepository: ProductDetailRepository,
    private val userRepository: UserRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState<ProductDetailInfo>>(UiState.Loading)
    val uiState: StateFlow<UiState<ProductDetailInfo>> = _uiState.asStateFlow()

    fun fetchProductDetail(productId: Long, userId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading

            runCatching {
                Triple(
                    productRepository.getProductInfo(productId).getOrThrow(),
                    userRepository.getUserInfo(userId).getOrThrow(),
                    productRepository.getSellingProducts(userId).getOrThrow()
                )
            }.onSuccess { (productInfo, userInfo, relatedProducts) ->
                _uiState.value = UiState.Success(
                    ProductDetailInfo(
                        productInfo = productInfo,
                        userInfo = userInfo,
                        relatedProducts = relatedProducts
                    )
                )
            }.onFailure { error ->
                _uiState.value = UiState.Error(error.message)
            }
        }
    }
}
