package org.sopt.carrot.domain.repository

import org.sopt.carrot.domain.model.SearchModel

interface SearchRepository {
    suspend fun getSearchResults(keyword: String?): Result<Pair<List<SearchModel>, List<SearchModel>>>
}
