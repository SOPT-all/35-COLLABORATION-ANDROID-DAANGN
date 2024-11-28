package org.sopt.carrot.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseUserInfoDto(
    @SerialName("user_id")
    val userId: Long,
    @SerialName("nickname")
    val nickname: String,
    @SerialName("profile_image")
    val profileImage: String? = null,
    @SerialName("address")
    val address: String
)
