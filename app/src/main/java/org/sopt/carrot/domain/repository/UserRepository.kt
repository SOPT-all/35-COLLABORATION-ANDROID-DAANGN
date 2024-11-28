package org.sopt.carrot.domain.repository

import org.sopt.carrot.domain.model.UserDetailModel

interface UserRepository {
    suspend fun getUserInfo(userId: Long): Result<UserDetailModel>
}
