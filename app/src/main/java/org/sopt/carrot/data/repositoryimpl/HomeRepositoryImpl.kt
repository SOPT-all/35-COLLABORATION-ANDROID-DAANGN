package org.sopt.carrot.data.repositoryimpl

import org.sopt.carrot.data.mapper.toHomeProductModel
import org.sopt.carrot.data.service.HomeService
import org.sopt.carrot.domain.model.HomeProduct
import org.sopt.carrot.domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val homeService: HomeService
) : HomeRepository {
    override suspend fun getHomeProduct(
        category: List<String>?
    ): Result<List<HomeProduct>> = runCatching {
        val products = homeService.getHomeProduct(category).result?.products
        products?.map { it.toHomeProductModel() } ?: emptyList()
    }
}
