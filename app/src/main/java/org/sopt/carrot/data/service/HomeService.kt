package org.sopt.carrot.data.service

import org.sopt.carrot.data.model.response.BaseResponse
import org.sopt.carrot.data.model.response.ResponseHomeDto
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeService {
    @GET("/api/home")
    suspend fun getHomeProduct(
        @Query("category") category: List<String>?,
    ): BaseResponse<ResponseHomeDto>
}
