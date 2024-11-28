package org.sopt.carrot.data.mapper

import org.sopt.carrot.data.model.response.ResponseProductInfoDto
import org.sopt.carrot.data.model.response.ResponseRelatedProductsDto
import org.sopt.carrot.domain.model.ProductDetailModel
import org.sopt.carrot.domain.model.RelatedProductModel

internal fun ResponseProductInfoDto.toModel() = ProductDetailModel(
    productId = productId,
    productImage = productImage,
    title = title,
    category = category,
    content = content,
    price = price,
    view = view
)

internal fun ResponseRelatedProductsDto.RelatedProduct.toModel() = RelatedProductModel(
    id = id,
    productImage = productImage,
    title = title,
    price = price
)
