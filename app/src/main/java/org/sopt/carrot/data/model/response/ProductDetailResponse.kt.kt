package org.sopt.carrot.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductDetailResponse(
    @SerialName("status")
    val status: Int,
    @SerialName("result")
    val result: ProductInfo
)

@Serializable
data class ProductInfo(
    @SerialName("productId")
    val productId: Long,
    @SerialName("productImage")
    val productImage: String,
    @SerialName("title")
    val title: String,
    @SerialName("category")
    val category: String,
    @SerialName("content")
    val content: String,
    @SerialName("price")
    val price: String,
    @SerialName("view")
    val view: Int
)
