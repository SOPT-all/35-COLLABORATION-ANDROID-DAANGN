package org.sopt.carrot.domain.repository

import org.sopt.carrot.domain.model.ProductDetail
import org.sopt.carrot.domain.model.RelatedProduct

interface ProductDetailRepository {
    suspend fun getProductInfo(productId: Long): Result<ProductDetail>
    suspend fun getSellingProducts(userId: Long): Result<List<RelatedProduct>>
}
