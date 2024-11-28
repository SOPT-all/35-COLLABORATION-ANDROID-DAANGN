package org.sopt.carrot.domain.model

data class UserDetailModel(
    val userId: Long,
    val nickname: String,
    val profileImage: String? = null,
    val address: String
)

data class ProductDetailModel(
    val productId: Long,
    val productImage: String,
    val title: String? = null,
    val content: String? = null,
    val category: String,
    val price: String,
    val view: Int
)

data class RelatedProductModel(
    val id: Long,
    val productImage: String,
    val title: String? = null,
    val price: String
)
