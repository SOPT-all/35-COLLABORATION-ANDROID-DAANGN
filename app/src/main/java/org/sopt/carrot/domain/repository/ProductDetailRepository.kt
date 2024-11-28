package org.sopt.carrot.domain.repository

import org.sopt.carrot.domain.model.ProductDetailModel
import org.sopt.carrot.domain.model.RelatedProductModel

interface ProductDetailRepository {
    suspend fun getProductInfo(productId: Long): Result<ProductDetailModel>
    suspend fun getSellingProducts(userId: Long): Result<List<RelatedProductModel>>
}
