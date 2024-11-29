package org.sopt.carrot.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.carrot.domain.model.HomeProduct
import org.sopt.carrot.domain.repository.HomeRepository
import org.sopt.carrot.presentation.util.UiState

class MainViewModel(
    private val homeRepository: HomeRepository
) : ViewModel() {

    private val products = MutableStateFlow<UiState<List<HomeProduct>>>(UiState.Loading)
    val product get() = products.asStateFlow()


    private var _category: List<String>? = null

    fun setCategory(category: List<String>?) {
        _category = category
    }

    fun getHomeProduct() {
        viewModelScope.launch {
            products.value = UiState.Loading
            homeRepository.getHomeProduct(_category)
                .onSuccess { productList ->
                    products.value = if (productList.isEmpty()) {
                        UiState.Empty
                    } else {
                        UiState.Success(productList)
                    }
                }
                .onFailure { throwable ->
                    products.value = UiState.Error(throwable.message)
                }
        }
    }
}

