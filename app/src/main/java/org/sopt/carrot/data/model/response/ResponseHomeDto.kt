package org.sopt.carrot.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseHomeDto(
    @SerialName("products")
    val products: List<Product>
) {
    @Serializable
    data class Product(
        @SerialName("address")
        val address: String,
        @SerialName("id")
        val id: Int,
        @SerialName("price")
        val price: String,
        @SerialName("product_image")
        val productImage: String,
        @SerialName("title")
        val title: String,
        @SerialName("user_id")
        val userId: Int,
        @SerialName("view")
        val view: Int,
    )
}
