package org.sopt.carrot.data.service

import org.sopt.carrot.data.model.response.ProductDetailResponse
import org.sopt.carrot.data.model.response.RelatedProductResponse
import org.sopt.carrot.data.model.response.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductApiService {
    @GET("/api/search")
    suspend fun searchProducts(
        @Query("keyword") keyword: String
    ): Response<SearchResponse>

    @GET("/api/products/{productId}")
    suspend fun getProductDetail(
        @Path("productId") productId: Long
    ): Response<ProductDetailResponse>

    @GET("/api/users/{userId}/selling-products")
    suspend fun getSellingProducts(
        @Path("userId") userId: Long
    ): Response<RelatedProductResponse>
}
