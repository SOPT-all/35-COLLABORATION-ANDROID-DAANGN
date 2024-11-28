package org.sopt.carrot.data.mapper

import org.sopt.carrot.data.model.response.ResponseProductInfoDto
import org.sopt.carrot.data.model.response.ResponseRelatedProductDto
import org.sopt.carrot.data.model.response.ResponseUserInfoDto
import org.sopt.carrot.domain.model.ProductDetailModel
import org.sopt.carrot.domain.model.RelatedProductModel
import org.sopt.carrot.domain.model.UserDetailModel

object ProductDetailMapper {
    fun ResponseProductInfoDto.toModel() = ProductDetailModel(
        productId = productId,
        productImage = productImage,
        title = title,
        category = category,
        content = content,
        price = price,
        view = view
    )

    fun ResponseUserInfoDto.toModel() = UserDetailModel(
        userId = userId,
        nickname = nickname,
        profileImage = profileImage,
        address = address
    )

    fun ResponseRelatedProductDto.toModel() = RelatedProductModel(
        id = id,
        productImage = productImage,
        title = title,
        price = price
    )
}
