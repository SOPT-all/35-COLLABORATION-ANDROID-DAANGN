package org.sopt.carrot.data.repositoryimpl

import org.sopt.carrot.data.mapper.toUserDetail
import org.sopt.carrot.data.model.response.isClientError
import org.sopt.carrot.data.model.response.isServerError
import org.sopt.carrot.data.model.response.isSuccess
import org.sopt.carrot.data.service.UserService
import org.sopt.carrot.domain.model.UserDetail
import org.sopt.carrot.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userService: UserService
) : UserRepository {

    override suspend fun getUserInfo(userId: Long): Result<UserDetail> = runCatching {
        val response = userService.getUserInfo(userId)

        when {
            response.isSuccess() -> {
                val userInfoDto = response.result ?: throw IllegalStateException("응답 성공 근데 값이 null")
                userInfoDto.toUserDetail()
            }

            response.isClientError() -> throw ClientException(
                response.message ?: "클라이언트 오류 발생"
            )

            response.isServerError() -> throw ServerException(
                "서버 오류 발생 : ${response.status}"
            )

            else -> throw IllegalStateException(
                "예기치 않은 status code: ${response.status}"
            )
        }
    }
}
