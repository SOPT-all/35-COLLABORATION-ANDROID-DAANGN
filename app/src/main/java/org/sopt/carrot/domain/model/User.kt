package org.sopt.carrot.domain.model

data class UserDetail(
    val userId: Long,
    val nickname: String,
    val profileImage: String? = null,
    val address: String
)
