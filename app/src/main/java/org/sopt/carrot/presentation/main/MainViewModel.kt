package org.sopt.carrot.presentation.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.carrot.domain.model.HomeProductModel
import org.sopt.carrot.domain.repository.HomeRepository
import org.sopt.carrot.presentation.util.UiState

class MainViewModel(
    private val homeRepository: HomeRepository
) : ViewModel() {

    private val products = MutableStateFlow<UiState<List<HomeProductModel>>>(UiState.Loading)
    val product get() = products.asStateFlow()

    //일단은 이렇게 작성
    val category: List<String>? = null

    fun fetchProducts() {
        viewModelScope.launch {
            products.value = UiState.Loading
            homeRepository.getHomeProduct(category)
                .onSuccess { productList ->
                    if (productList.isEmpty()) {
                        products.value = UiState.Empty
                    } else {
                        products.value = UiState.Success(productList)
                        Log.d("ddd","이건성공")
                    }
                }
                .onFailure { throwable ->
                    products.value = UiState.Error(throwable.message)
                    Log.d("dddd",products.value.toString())

                }
        }
    }
}

