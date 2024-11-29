package org.sopt.carrot.presentation.sellerProfile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.carrot.data.repositoryimpl.ClientException
import org.sopt.carrot.data.repositoryimpl.ServerException
import org.sopt.carrot.domain.model.UserDetail
import org.sopt.carrot.domain.repository.UserRepository

class SellerProfileViewmodel(
    private val userRepository: UserRepository
) : ViewModel() {

    var sellerProfile by mutableStateOf(
        UserDetail(
            userId = -1L,
            nickname = "",
            profileImage = "",
            address = ""
        )
    )
        private set

    fun fetchSellerProfile(userId: Long) {
        viewModelScope.launch {
            val result = userRepository.getUserInfo(userId)

            result
                .onSuccess { fetchedSellerProfile ->
                    sellerProfile = fetchedSellerProfile
                }
                .onFailure { error ->
                    val errorMessage = when (error) {
                        is ClientException -> error.message
                        is ServerException -> error.message
                        else -> "알 수 없는 오류 발생."
                    }
                }
        }
    }
}
