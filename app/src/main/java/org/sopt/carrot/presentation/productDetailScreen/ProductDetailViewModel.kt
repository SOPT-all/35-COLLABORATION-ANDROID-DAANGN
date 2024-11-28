package org.sopt.carrot.presentation.productDetailScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.carrot.domain.model.ProductDetailModel
import org.sopt.carrot.domain.model.RelatedProductModel
import org.sopt.carrot.domain.model.UserDetailModel
import org.sopt.carrot.domain.repository.ProductDetailRepository
import org.sopt.carrot.domain.repository.UserRepository
import org.sopt.carrot.presentation.util.UiState

class ProductDetailViewModel(
    private val productRepository: ProductDetailRepository,
    private val userRepository: UserRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState<DetailState>>(UiState.Loading)
    val uiState: StateFlow<UiState<DetailState>> = _uiState.asStateFlow()

    data class DetailState(
        val productInfo: ProductDetailModel,
        val userInfo: UserDetailModel,
        val relatedProducts: List<RelatedProductModel>
    )

    fun fetchProductDetail(productId: Long, userId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val productInfo = productRepository.getProductInfo(productId).getOrThrow()
                val userInfo = userRepository.getUserInfo(userId).getOrThrow()
                val relatedProducts = productRepository.getSellingProducts(userId).getOrThrow()

                _uiState.value = UiState.Success(DetailState(productInfo, userInfo, relatedProducts))
            } catch (e: Exception) {
                e.printStackTrace()
                _uiState.value = UiState.Error(e.message)
            }
        }
    }
}
