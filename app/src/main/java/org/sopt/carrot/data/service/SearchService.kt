package org.sopt.carrot.data.service

import org.sopt.carrot.data.model.response.BaseResponse
import org.sopt.carrot.data.model.response.ResponseSearchDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
    @GET("/api/search")
    suspend fun getSearchProducts(
        @Query("keyword") keyword: String?
    ): BaseResponse<ResponseSearchDto>
}
