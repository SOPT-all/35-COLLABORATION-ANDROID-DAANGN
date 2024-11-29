package org.sopt.carrot.presentation.main

import org.sopt.carrot.domain.model.HomeProduct
import kotlin.random.Random

fun generateRandomTime(): String {
    val hours = Random.nextInt(0, 24)
    return if (hours == 0) {
        "${Random.nextInt(1, 60)}분 전"
    } else {
        "${hours}시간 전"
    }
}


fun generateRandomDistance(): String? {
    return if (Random.nextBoolean()) "${Random.nextDouble(1.0, 10.0).format(1)}km" else null
}

fun generateRandomChat(): String? {
    return if (Random.nextBoolean()) "${Random.nextInt(1, 11)}" else null
}

fun Double.format(digits: Int) = "%.${digits}f".format(this)

fun addRandomDataToProducts(products: List<HomeProduct>): List<HomeProduct> {
    return products.map { product ->
        product.copy(
            time = product.time ?: generateRandomTime(),
            distance = product.distance ?: generateRandomDistance(),
            chat = product.chat ?: generateRandomChat()
        )
    }
}
