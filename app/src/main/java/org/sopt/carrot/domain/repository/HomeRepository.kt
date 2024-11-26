package org.sopt.carrot.domain.repository

import org.sopt.carrot.domain.model.HomeProductModel

interface HomeRepository {
    suspend fun getHomeProduct(category: List<String>?): Result<List<HomeProductModel>>
}
