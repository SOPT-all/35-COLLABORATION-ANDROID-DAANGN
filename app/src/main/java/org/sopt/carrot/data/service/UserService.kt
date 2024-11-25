package org.sopt.carrot.data.service

import org.sopt.carrot.data.model.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("api/users/{userId}")
    suspend fun getUserInfo(
        @Path("userId") userId: Long
    ): UserResponse
}
