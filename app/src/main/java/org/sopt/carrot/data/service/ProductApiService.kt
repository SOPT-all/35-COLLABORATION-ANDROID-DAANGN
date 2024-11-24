package org.sopt.carrot.data.service

import org.sopt.carrot.data.dto.response.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApiService {
    @GET("/api/search")
    suspend fun searchProducts(
        @Query("keyword") keyword: String
    ): Response<SearchResponse>
}
