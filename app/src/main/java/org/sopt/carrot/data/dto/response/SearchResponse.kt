package org.sopt.carrot.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    val status: Int,
    val result: SearchResult
)

@Serializable
data class SearchResult(
    val products: List<Product>,
    val similar_products: List<Product>
)

@Serializable
data class Product(
    val id: Long,
    val user_id: Long,
    val product_image: String,
    val title: String,
    val address: String,
    val price: String
)
