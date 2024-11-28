package org.sopt.carrot.domain.repository

import org.sopt.carrot.domain.model.ProductDetailModel
import org.sopt.carrot.domain.model.RelatedProductModel
import org.sopt.carrot.domain.model.UserDetailModel

interface ProductDetailRepository {
    suspend fun getProductInfo(productId: Long): Result<ProductDetailModel>
    suspend fun getUserInfo(userId: Long): Result<UserDetailModel>
    suspend fun getSellingProducts(userId: Long): Result<List<RelatedProductModel>>
}
