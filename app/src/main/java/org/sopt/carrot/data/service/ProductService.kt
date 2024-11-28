package org.sopt.carrot.data.service

import org.sopt.carrot.data.model.response.BaseResponse
import org.sopt.carrot.data.model.response.ResponseProductInfoDto
import org.sopt.carrot.data.model.response.ResponseRelatedProductsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApiService {
    @GET("/api/products/{productId}")
    suspend fun getProductDetail(
        @Path("productId") productId: Long
    ): BaseResponse<ResponseProductInfoDto>

    @GET("/api/users/{userId}/selling-products")
    suspend fun getSellingProducts(
        @Path("userId") userId: Long
    ): BaseResponse<ResponseRelatedProductsDto>
}
