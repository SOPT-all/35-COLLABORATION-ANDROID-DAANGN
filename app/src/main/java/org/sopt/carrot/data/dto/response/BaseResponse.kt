package org.sopt.carrot.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    val status: Int,
    val result: T? = null,
    val message: String? = null,
)
