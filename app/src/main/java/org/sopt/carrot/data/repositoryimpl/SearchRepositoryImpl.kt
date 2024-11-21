package org.sopt.carrot.data.repositoryimpl

import org.sopt.carrot.data.model.response.SearchResult
import org.sopt.carrot.data.service.ProductApiService
import org.sopt.carrot.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val productApiService: ProductApiService
) : SearchRepository {
    override suspend fun searchProducts(keyword: String): Result<SearchResult> = runCatching {
        val response = productApiService.searchProducts(keyword)
        if (response.isSuccessful) {
            response.body()?.result ?: throw Exception("응답 데이터가 없습니다.")
        } else {
            throw Exception("검색에 실패했습니다.")
        }
    }
}