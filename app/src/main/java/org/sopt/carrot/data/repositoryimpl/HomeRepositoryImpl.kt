package org.sopt.carrot.data.repositoryimpl

import android.util.Log
import org.sopt.carrot.data.mapper.toHomeProductModel
import org.sopt.carrot.data.service.HomeService
import org.sopt.carrot.domain.model.HomeProductModel
import org.sopt.carrot.domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val homeService: HomeService
) : HomeRepository {
    override suspend fun getHomeProduct(
        category: List<String>?
    ): Result<List<HomeProductModel>> = runCatching {

        homeService.getHomeProduct(category).result?.products?.map {
            it.toHomeProductModel()
        }

    }.mapCatching {
        requireNotNull(it) { "Product list is null" }
    }.recoverCatching {
        emptyList<HomeProductModel>()
    }
}
