package org.sopt.carrot.data.mapper

import org.sopt.carrot.data.model.response.ResponseProductInfoDto
import org.sopt.carrot.data.model.response.ResponseRelatedProductsDto
import org.sopt.carrot.domain.model.ProductDetail
import org.sopt.carrot.domain.model.RelatedProduct

fun ResponseProductInfoDto.toProductDetail() = ProductDetail(
    productId = productId,
    productImage = productImage,
    title = title,
    category = category,
    content = content,
    price = price,
    view = view
)

fun ResponseRelatedProductsDto.RelatedProduct.toRelatedProduct() = RelatedProduct(
    id = id,
    productImage = productImage,
    title = title,
    price = price
)
