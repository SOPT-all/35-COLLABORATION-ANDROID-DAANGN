package org.sopt.carrot.data.repositoryimpl

import org.sopt.carrot.data.mapper.toModel
import org.sopt.carrot.data.service.ProductApiService
import org.sopt.carrot.domain.repository.ProductDetailRepository

class ProductDetailRepositoryImpl(
    private val productService: ProductApiService,
) : ProductDetailRepository {
    override suspend fun getProductInfo(productId: Long) = runCatching {
        val response = productService.getProductDetail(productId)
        response.result?.toModel() ?: throw IllegalStateException("Response body is null")
    }

    override suspend fun getSellingProducts(userId: Long) = runCatching {
        val response = productService.getSellingProducts(userId)
        response.result?.products?.map { product -> product.toModel() }
            ?: throw IllegalStateException("Response body is null")
    }
}
