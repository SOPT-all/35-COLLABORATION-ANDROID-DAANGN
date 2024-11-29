package org.sopt.carrot.domain.model

data class ProductDetail(
    val productId: Long,
    val productImage: String,
    val title: String? = null,
    val content: String? = null,
    val category: String,
    val price: String,
    val view: Int
)

data class RelatedProduct(
    val id: Long,
    val productImage: String,
    val title: String? = null,
    val price: String
)
