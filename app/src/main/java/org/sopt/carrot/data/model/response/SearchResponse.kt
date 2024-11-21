package org.sopt.carrot.data.model.response

data class SearchResponse(
    val status: Int,
    val result: SearchResult
)

data class SearchResult(
    val products: List<Product>,
    val similar_products: List<Product>
)

data class Product(
    val id: Long,
    val user_id: Long,
    val product_image: String,
    val title: String,
    val address: String,
    val price: String
)