package org.sopt.carrot.domain.repository

import org.sopt.carrot.domain.model.Categories

interface CategoryRepository {

    suspend fun fetchCategories(): Result<Categories>

    fun clearCache()

}
