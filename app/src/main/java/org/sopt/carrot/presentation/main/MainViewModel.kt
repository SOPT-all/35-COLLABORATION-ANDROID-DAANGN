package org.sopt.carrot.presentation.main

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import org.sopt.carrot.domain.model.MainProductModel

class MainViewModel : ViewModel() {
    val products = mutableStateOf(
        listOf(
            MainProductModel(
                productImage = "https://ibb.co/s1y6Nyj",
                title = "산산기어 스웻집업(마지막가격)",
                address = "위례동",
                price = "70,000원",
                view = 8,
                time = "13분 전",
                id = 2,
                userId = 2,
                chat = "3"
            ),
            MainProductModel(
                productImage = "https://ibb.co/s1y6Nyj",
                title = "산산기어 스웻집업(마지막가격)",
                address = "위례동",
                time = "13분 전",
                price = "70,000원",
                view = 8,
                id = 2,
                userId = 2
            ),
            MainProductModel(
                productImage = "https://ibb.co/s1y6Nyj",
                title = "산산기어 스웻집업(마지막가격)",
                address = "위례동",
                price = "70,000원",
                view = 8,
                id = 2,
                userId = 2,
                distance = "2.5km",
                time = "13분 전",
                chat = "3"
            ),
            MainProductModel(
                productImage = "https://ibb.co/s1y6Nyj",
                title = "산산기어 스웻집업(마지막가격)",
                address = "위례동",
                time = "13분 전",
                price = "70,000원",
                view = 8,
                id = 2,
                userId = 2
            ),
            MainProductModel(
                productImage = "https://ibb.co/s1y6Nyj",
                title = "산산기어 스웻집업(마지막가격)",
                address = "위례동",
                price = "70,000원",
                view = 8,
                id = 2,
                userId = 2,
                distance = "2.5km",
                time = "13분 전",
                chat = "3"
            ),
            MainProductModel(
                productImage = "https://ibb.co/s1y6Nyj",
                title = "산산기어 스웻집업(마지막가격)",
                address = "위례동",
                time = "13분 전",
                price = "70,000원",
                view = 8,
                id = 2,
                userId = 2
            )
        )
    )
}
