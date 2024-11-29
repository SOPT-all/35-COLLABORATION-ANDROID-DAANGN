package org.sopt.carrot.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseProductInfoDto(
    @SerialName("product_id")
    val productId: Long,
    @SerialName("product_image")
    val productImage: String,
    @SerialName("title")
    val title: String? = null,
    @SerialName("content")
    val content: String? = null,
    @SerialName("category")
    val category: String,
    @SerialName("price")
    val price: String,
    @SerialName("view")
    val view: Int
)
