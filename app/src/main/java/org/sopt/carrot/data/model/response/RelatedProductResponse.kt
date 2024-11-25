package org.sopt.carrot.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RelatedProductResponse(
    @SerialName("status")
    val status: Int,
    @SerialName("result")
    val result: RelatedProducts
)

@Serializable
data class RelatedProducts(
    @SerialName("products")
    val products: List<RelatedProduct>
)

@Serializable
data class RelatedProduct(
    @SerialName("id")
    val id: Long,
    @SerialName("productImage")
    val productImage: String,
    @SerialName("title")
    val title: String,
    @SerialName("price")
    val price: String
)
