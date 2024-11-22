package org.sopt.carrot.presentation.category

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CategoryViewmodel : ViewModel() {

    private val categories = listOf(
        "디지털기기",
        "가구/인테리어",
        "유아동",
        "여성의류",
        "여성잡화",
        "남성패션/잡화",
        "생활가전",
        "생활/주방",
        "스포츠/레저",
        "취미/게임/음반",
        "뷰티/미용",
        "식물",
        "가공식품",
        "건강기능식품",
        "반려동물용품",
        "티켓/교환권",
        "도서",
        "유아도서",
        "기타 중고물품",
        "삽니다"
    )

    var categorySelections by mutableStateOf(categories.associateWith { false })
        private set

    var selectedCategories by mutableStateOf<List<String>>(emptyList())
        private set

    fun check(): Boolean = (selectedCategories.isNotEmpty())

    fun toggleCategoryProcess(category: String) {
        toggleCategory(category)
        addSelectedCategories(category)
    }

    private fun toggleCategory(category: String) {
        categorySelections = categorySelections.toMutableMap().apply {
            this[category] = !(this[category] ?: false)
        }
    }

    private fun addSelectedCategories(category: String) {
        selectedCategories = when (categorySelections[category] == true) {
            true -> selectedCategories.plus(category)
            false -> selectedCategories.minus(category)
        }
    }

    fun clearSelectedCategories() {
        categorySelections = categories.associateWith { false }
        selectedCategories = emptyList()
    }

}
