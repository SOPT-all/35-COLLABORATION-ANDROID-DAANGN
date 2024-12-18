package org.sopt.carrot.domain.model


data class MainProductModel(
    val id: Int,
    val userId: Int,
    val productImage: String,
    val title: String,
    val price: String,
    val address: String,
    val view: Int,
    val time: String? = null,
    val distance: String? = null,
    val chat: String? = null,
)
