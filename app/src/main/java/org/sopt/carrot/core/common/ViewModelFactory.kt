package org.sopt.carrot.core.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.carrot.data.ServicePool
import org.sopt.carrot.data.repositoryimpl.DummyRepositoryImpl
import org.sopt.carrot.data.repositoryimpl.HomeRepositoryImpl
import org.sopt.carrot.presentation.ExampleScreen1.ExampleScreen1ViewModel
import org.sopt.carrot.presentation.main.MainViewModel


class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {

            ExampleScreen1ViewModel::class.java -> {
                ExampleScreen1ViewModel(DummyRepositoryImpl(ServicePool.dummyService)) as T
            }

            MainViewModel::class.java -> {
                MainViewModel(
                    HomeRepositoryImpl(ServicePool.homeService)
                ) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }
}
