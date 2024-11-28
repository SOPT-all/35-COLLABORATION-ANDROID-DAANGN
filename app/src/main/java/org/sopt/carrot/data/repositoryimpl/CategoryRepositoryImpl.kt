package org.sopt.carrot.data.repositoryimpl

import org.sopt.carrot.data.model.response.isClientError
import org.sopt.carrot.data.model.response.isServerError
import org.sopt.carrot.data.model.response.isSuccess
import org.sopt.carrot.data.model.response.mapToCategories
import org.sopt.carrot.data.service.CategoryService
import org.sopt.carrot.domain.model.Categories
import org.sopt.carrot.domain.repository.CategoryRepository

class CategoryRepositoryImpl(
    private val categoryService: CategoryService
) : CategoryRepository {

    private var cachedCategories: Categories? = null

    override suspend fun fetchCategories(): Result<Categories> = runCatching {
        cachedCategories ?: run {
            val response = categoryService.fetchCategories()

            when {
                response.isSuccess() -> {
                    val categoriesDto = response.result ?: throw IllegalStateException("응답 성공 근데 값이 null")
                    categoriesDto.mapToCategories().also { cachedCategories = it }
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

    override fun clearCache() {
        cachedCategories = null
    }

}

class ClientException(message: String) : Exception(message)
class ServerException(message: String) : Exception(message)
