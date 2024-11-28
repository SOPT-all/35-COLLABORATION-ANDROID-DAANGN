package org.sopt.carrot.domain.repository

import org.sopt.carrot.domain.model.Search

interface SearchRepository {
    suspend fun getSearchResults(keyword: String?): Result<Search>
}
