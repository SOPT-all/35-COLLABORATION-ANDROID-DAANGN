package org.sopt.carrot.presentation.titleSearchScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.carrot.data.model.SearchProductModel
import org.sopt.carrot.domain.repository.SearchRepository
import org.sopt.carrot.presentation.util.UiState

class SearchViewModel(
    private val searchRepository: SearchRepository
) : ViewModel() {
    private val _searchResults =
        MutableStateFlow<UiState<Pair<List<SearchProductModel>, List<SearchProductModel>>>>(UiState.Empty)
    val searchResults = _searchResults.asStateFlow()

    fun searchProducts(keyword: String?) {
        viewModelScope.launch {
            _searchResults.value = UiState.Loading
            searchRepository.getSearchResults(keyword)
                .onSuccess { (products, similarProducts) ->
                    _searchResults.value = if (products.isEmpty() && similarProducts.isEmpty()) {
                        UiState.Empty
                    } else {
                        UiState.Success(Pair(products, similarProducts))
                    }
                }
                .onFailure { throwable ->
                    _searchResults.value = UiState.Error(throwable.message)
                }
        }
    }
}
