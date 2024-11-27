package org.sopt.carrot.domain.repository

import org.sopt.carrot.data.model.SearchProductModel

interface SearchRepository {
    suspend fun getSearchResults(keyword: String?): Result<Pair<List<SearchProductModel>, List<SearchProductModel>>>
}
