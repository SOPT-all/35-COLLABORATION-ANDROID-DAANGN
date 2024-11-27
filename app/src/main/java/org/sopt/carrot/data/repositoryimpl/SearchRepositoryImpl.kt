package org.sopt.carrot.data.repositoryimpl

import org.sopt.carrot.data.model.SearchMapper.toModel
import org.sopt.carrot.data.model.SearchProductModel
import org.sopt.carrot.data.model.response.ResponseSearchDto
import org.sopt.carrot.data.service.SearchService
import org.sopt.carrot.domain.repository.SearchRepository

class SearchRepositoryImpl(
    private val searchService: SearchService
) : SearchRepository {
    override suspend fun getSearchResults(keyword: String?): Result<Pair<List<SearchProductModel>, List<SearchProductModel>>> = runCatching {
            val response = searchService.getSearchProducts(keyword)
            Pair(
                response.result?.products?.map { it.toModel() } ?: emptyList(),
                response.result?.similarProducts?.map { it.toModel() } ?: emptyList()
            )
        }
}
