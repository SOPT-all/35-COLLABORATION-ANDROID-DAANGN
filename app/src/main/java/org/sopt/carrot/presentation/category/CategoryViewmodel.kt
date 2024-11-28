package org.sopt.carrot.presentation.category

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.carrot.data.repositoryimpl.ClientException
import org.sopt.carrot.data.repositoryimpl.ServerException
import org.sopt.carrot.domain.repository.CategoryRepository

class CategoryViewmodel(
    private val categoryRepository: CategoryRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var categories by mutableStateOf(
        value = savedStateHandle.get<Map<String, Boolean>>(CATEGORIES_KEY) ?: emptyMap()
    )
        private set

    var selectedCategories by mutableStateOf(
        value = savedStateHandle.get<List<String>>(SELECTED_CATEGORIES_KEY) ?: emptyList()
    )
        private set

    fun fetchCategory() {
        if (categories.isNotEmpty()) return
        viewModelScope.launch {
            val result = categoryRepository.fetchCategories()

            result
                .onSuccess { fetchedCategories ->
                    initializeCategories(fetchedCategories.categories)
                }
                .onFailure { error ->
                    val errorMessage = when (error) {
                        is ClientException -> error.message
                        is ServerException -> error.message
                        else -> "알 수 없는 오류 발생."
                    }
                }
        }
    }

    private fun initializeCategories(fetchedCategories: List<String>) {
        categories = fetchedCategories.associateWith { false }
    }

    fun toggleCategoryProcess(category: String) {
        val newCategories = toggleCategory(category)
        updateCategories(newCategories)

        val newSelected = addSelectedCategories(newCategories, category)
        updateSelectedCategories(newSelected)
    }

    private fun toggleCategory(category: String): MutableMap<String, Boolean> =
        categories.toMutableMap().apply {
            this[category] = !(this[category] ?: false)
        }

    private fun updateCategories(newCategories: Map<String, Boolean>) {
        categories = newCategories
        savedStateHandle[CATEGORIES_KEY] = newCategories
    }

    private fun addSelectedCategories(
        newCategories: MutableMap<String, Boolean>,
        category: String
    ) = when (newCategories[category] == true) {
        true -> selectedCategories.plus(category)
        false -> selectedCategories.minus(category)
    }

    private fun updateSelectedCategories(newSelected: List<String>) {
        selectedCategories = newSelected
        savedStateHandle[SELECTED_CATEGORIES_KEY] = newSelected
    }

    fun clearSelectedCategories() {
        updateCategories(categories.mapValues { false })
        updateSelectedCategories(emptyList())
    }

    fun check(): Boolean = (selectedCategories.isNotEmpty())

    companion object {
        private const val CATEGORIES_KEY = "categories_key"
        private const val SELECTED_CATEGORIES_KEY = "selected_categories_key"
    }
}
