package org.sopt.carrot.core.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import org.sopt.carrot.data.ServicePool
import org.sopt.carrot.data.repositoryimpl.CategoryRepositoryImpl
import org.sopt.carrot.data.repositoryimpl.DummyRepositoryImpl
import org.sopt.carrot.presentation.ExampleScreen1.ExampleScreen1ViewModel
import org.sopt.carrot.presentation.category.CategoryViewmodel


class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {

        val savedStateHandle = extras.createSavedStateHandle()

        return when (modelClass) {

            ExampleScreen1ViewModel::class.java -> {
                ExampleScreen1ViewModel(DummyRepositoryImpl(ServicePool.dummyService)) as T
            }

            CategoryViewmodel::class.java -> {
                CategoryViewmodel(
                    CategoryRepositoryImpl(ServicePool.categoryService),
                    savedStateHandle = savedStateHandle
                ) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }
}
