package org.sopt.carrot.data.model.mapper

import org.sopt.carrot.data.model.response.ResponseSearchDto
import org.sopt.carrot.domain.model.SearchModel

object SearchMapper {
    fun ResponseSearchDto.Product.toModel() = SearchModel(
        id = id,
        userId = userId,
        productImage = productImage,
        title = title,
        address = address,
        price = price
    )
}
