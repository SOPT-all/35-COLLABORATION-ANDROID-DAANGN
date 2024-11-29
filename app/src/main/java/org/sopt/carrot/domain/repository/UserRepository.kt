package org.sopt.carrot.domain.repository

import org.sopt.carrot.domain.model.UserDetail

interface UserRepository {
    suspend fun getUserInfo(userId: Long): Result<UserDetail>
}
