package org.sopt.carrot.data.mapper

import org.sopt.carrot.data.model.response.ResponseUserInfoDto
import org.sopt.carrot.domain.model.UserDetail

fun ResponseUserInfoDto.toUserDetail() = UserDetail(
    userId = userId,
    nickname = nickname,
    profileImage = profileImage,
    address = address
)
