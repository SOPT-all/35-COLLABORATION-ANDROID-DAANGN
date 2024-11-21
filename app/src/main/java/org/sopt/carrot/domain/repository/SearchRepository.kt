package org.sopt.carrot.domain.repository

import org.sopt.carrot.data.model.response.SearchResult

interface SearchRepository {
    suspend fun searchProducts(keyword: String): Result<SearchResult>
}