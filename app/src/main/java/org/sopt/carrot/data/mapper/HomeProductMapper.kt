package org.sopt.carrot.data.mapper

import org.sopt.carrot.data.model.response.ResponseHomeDto
import org.sopt.carrot.domain.model.HomeProduct

internal fun ResponseHomeDto.Product.toHomeProductModel(): HomeProduct =
    HomeProduct(
        id = id,
        userId = userId,
        productImage = productImage,
        title = title,
        price = price,
        address = address,
        view = view,
    )
