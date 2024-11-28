package org.sopt.carrot.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseRelatedProductsDto(
    @SerialName("products")
    val products: List<ResponseRelatedProductDto>
)

@Serializable
data class ResponseRelatedProductDto(
    @SerialName("id")
    val id: Long,
    @SerialName("product_image")
    val productImage: String,
    @SerialName("title")
    val title: String? = null,
    @SerialName("price")
    val price: String
)
