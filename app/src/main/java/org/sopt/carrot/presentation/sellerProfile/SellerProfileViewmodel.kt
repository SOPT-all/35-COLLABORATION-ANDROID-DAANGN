package org.sopt.carrot.presentation.sellerProfile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.carrot.data.repositoryimpl.ClientException
import org.sopt.carrot.data.repositoryimpl.ServerException
import org.sopt.carrot.domain.model.UserDetail
import org.sopt.carrot.domain.repository.UserRepository

class SellerProfileViewmodel(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _sellerProfile = MutableStateFlow<UserDetail?>(null)
    val sellerProfile: StateFlow<UserDetail?> = _sellerProfile.asStateFlow()

    fun fetchSellerProfile(userId: Long) {
        viewModelScope.launch {
            val result = userRepository.getUserInfo(userId)

            result
                .onSuccess { fetchedSellerProfile ->
                    _sellerProfile.value = fetchedSellerProfile
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
