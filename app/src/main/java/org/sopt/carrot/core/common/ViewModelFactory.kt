package org.sopt.carrot.core.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {

//            ExampleScreen1ViewModel::class.java -> {
//                ExampleScreen1ViewModel(DummyRepositoryImpl(ServicePool.dummyService)) as T
//            }

            else -> throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }
}