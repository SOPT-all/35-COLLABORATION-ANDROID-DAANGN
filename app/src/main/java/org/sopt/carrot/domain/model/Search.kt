package org.sopt.carrot.domain.model

data class Search(
    val products: List<SearchProduct>,
    val similarProducts: List<SearchSimilarProduct>
)

data class SearchProduct(
    val id: Long,
    val userId: Long,
    val productImage: String,
    val title: String?,
    val address: String?,
    val price: String
)

data class SearchSimilarProduct(
    val id: Long,
    val userId: Long,
    val productImage: String,
    val title: String?,
    val address: String?,
    val price: String
)
