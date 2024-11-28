package org.sopt.carrot.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    val status: Int,
    val result: T? = null,
    val message: String? = null,
)

fun <T> BaseResponse<T>.isSuccess(): Boolean =
    status in 200..299

fun <T> BaseResponse<T>.isClientError(): Boolean =
    status in 400..499

fun <T> BaseResponse<T>.isServerError(): Boolean =
    status in 500..599
