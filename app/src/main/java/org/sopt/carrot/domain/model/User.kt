package org.sopt.carrot.domain.model

data class UserDetailModel(
    val userId: Long,
    val nickname: String,
    val profileImage: String? = null,
    val address: String
)
