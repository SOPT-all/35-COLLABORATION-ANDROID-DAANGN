package org.sopt.carrot.data.repositoryimpl

import org.sopt.carrot.data.mapper.toProductDetail
import org.sopt.carrot.data.mapper.toRelatedProduct
import org.sopt.carrot.data.service.ProductService
import org.sopt.carrot.domain.repository.ProductDetailRepository

class ProductDetailRepositoryImpl(
    private val productService: ProductService,
) : ProductDetailRepository {
    override suspend fun getProductInfo(productId: Long) = runCatching {
        val response = productService.getProductDetail(productId)
        response.result?.toProductDetail() ?: throw IllegalStateException("Response body is null")
    }

    override suspend fun getSellingProducts(userId: Long) = runCatching {
        val response = productService.getSellingProducts(userId)
        response.result?.products?.map { product -> product.toRelatedProduct() }
            ?: throw IllegalStateException("Response body is null")
    }
}
