package org.sopt.carrot.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.sopt.carrot.domain.model.Categories

@Serializable
data class ResponseCategoriesDto(
    @SerialName("categories")
    val categories: List<String>
)

fun ResponseCategoriesDto.mapToCategories(): Categories =
    Categories(
        categories = categories
    )
