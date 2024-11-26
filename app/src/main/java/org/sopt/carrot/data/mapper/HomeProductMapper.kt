package org.sopt.carrot.data.mapper

import org.sopt.carrot.data.dto.response.ResponseHomeDto
import org.sopt.carrot.domain.model.HomeProductModel

internal fun ResponseHomeDto.Product.toHomeProductModel(): HomeProductModel =
    HomeProductModel(
        id = id,
        userId = userId,
        productImage = productImage,
        title = title,
        price = price,
        address = address,
        view = view,
    )
