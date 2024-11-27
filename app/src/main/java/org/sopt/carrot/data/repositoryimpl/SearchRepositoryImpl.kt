package org.sopt.carrot.data.repositoryimpl

import org.sopt.carrot.data.model.SearchProductModel
import org.sopt.carrot.data.service.SearchService
import org.sopt.carrot.domain.repository.SearchRepository
import org.sopt.carrot.data.mapper.SearchMapper.toSearchProductModel

class SearchRepositoryImpl(
    private val searchService: SearchService
): SearchRepository {
    override suspend fun getSearchResults(keyword: String?): Result<Pair<List<SearchProductModel>, List<SearchProductModel>>> = runCatching {
            val response = searchService.getSearchProducts(keyword)
            Pair(
                response.result?.products?.map { it.toSearchProductModel() } ?: emptyList(),
                response.result?.similarProducts?.map { it.toSearchProductModel() } ?: emptyList()
            )
        }
}
