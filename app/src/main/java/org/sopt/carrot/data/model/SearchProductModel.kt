package org.sopt.carrot.data.model

data class SearchProductModel(
    val id: Long,
    val userId: Long,
    val productImage: String,
    val title: String?,
    val address: String?,
    val price: String
)
