package org.sopt.carrot.data.service

import org.sopt.carrot.data.model.response.BaseResponse
import org.sopt.carrot.data.model.response.ResponseCategoriesDto
import retrofit2.http.GET

interface CategoryService {

    @GET("/api/products/categories")
    suspend fun fetchCategories(): BaseResponse<ResponseCategoriesDto>

}
