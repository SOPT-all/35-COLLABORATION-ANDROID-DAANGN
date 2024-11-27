package org.sopt.carrot.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseSearchDto(
    @SerialName("products")
    val products: List<Product>,
    @SerialName("similar_products")
    val similarProducts: List<Product>
) {
    @Serializable
    data class Product(
        @SerialName("id")
        val id: Long,
        @SerialName("user_id")
        val userId: Long,
        @SerialName("product_image")
        val productImage: String,
        @SerialName("title")
        val title: String?,
        @SerialName("address")
        val address: String?,
        @SerialName("price")
        val price: String
    )
}

