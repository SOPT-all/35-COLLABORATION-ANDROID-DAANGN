package org.sopt.carrot.data.mapper

import org.sopt.carrot.data.model.response.Product
import org.sopt.carrot.data.model.response.SimilarProduct
import org.sopt.carrot.domain.model.SearchProduct
import org.sopt.carrot.domain.model.SearchSimilarProduct

internal fun Product.toSearchProduct(): SearchProduct =
    SearchProduct(
        id = id,
        userId = userId,
        productImage = productImage,
        title = title,
        address = address,
        price = price
    )

internal fun SimilarProduct.toSearchSimilarProduct(): SearchSimilarProduct =
    SearchSimilarProduct(
        id = id,
        userId = userId,
        productImage = productImage,
        title = title,
        address = address,
        price = price
    )
