package org.sopt.carrot.data.repositoryimpl


import org.sopt.carrot.data.mapper.toUserDetail
import org.sopt.carrot.data.service.UserService
import org.sopt.carrot.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userService: UserService
) : UserRepository {
    override suspend fun getUserInfo(userId: Long) = runCatching {
        userService.getUserInfo(userId).body()?.result?.toUserDetail()
            ?: throw IllegalStateException("Response body is null")
    }
}
