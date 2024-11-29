package org.sopt.carrot.domain.model

data class ProductDetailInfo(
    val productInfo: ProductDetail,
    val userInfo: UserDetail,
    val relatedProducts: List<RelatedProduct>
)
