package org.sopt.carrot.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    val status: Int,
    val data: T? = null,
    val message: String,
)
