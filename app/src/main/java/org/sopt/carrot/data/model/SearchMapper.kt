package org.sopt.carrot.data.model

import org.sopt.carrot.data.model.response.ResponseSearchDto

object SearchMapper {
    fun ResponseSearchDto.Product.toModel() = SearchProductModel(
        id = id,
        userId = userId,
        productImage = productImage,
        title = title,
        address = address,
        price = price
    )
}
