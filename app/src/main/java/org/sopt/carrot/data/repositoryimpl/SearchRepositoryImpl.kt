package org.sopt.carrot.data.repositoryimpl

import org.sopt.carrot.data.mapper.toSearchProduct
import org.sopt.carrot.data.mapper.toSearchSimilarProduct
import org.sopt.carrot.data.service.SearchService
import org.sopt.carrot.domain.model.Search
import org.sopt.carrot.domain.repository.SearchRepository

class SearchRepositoryImpl(
    private val searchService: SearchService
): SearchRepository {
    override suspend fun getSearchResults(keyword: String?): Result<Search> = runCatching {
        val response = searchService.getSearchProducts(keyword)
        Search(
            products = response.result?.products?.map { it.toSearchProduct() } ?: emptyList(),
            similarProducts = response.result?.similarProducts?.map { it.toSearchSimilarProduct() } ?: emptyList()
        )
    }

}
