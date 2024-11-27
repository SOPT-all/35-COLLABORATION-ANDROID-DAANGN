package org.sopt.carrot.domain.model

data class SearchModel(
    val id: Long,
    val userId: Long,
    val productImage: String,
    val title: String?,
    val address: String?,
    val price: String
)
