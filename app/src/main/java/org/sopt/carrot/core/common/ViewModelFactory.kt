package org.sopt.carrot.core.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.carrot.data.ServicePool
import org.sopt.carrot.data.repositoryimpl.DummyRepositoryImpl
import org.sopt.carrot.data.repositoryimpl.SearchRepositoryImpl
import org.sopt.carrot.presentation.ExampleScreen1.ExampleScreen1ViewModel
import org.sopt.carrot.presentation.titleSearchScreen.SearchViewModel


class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {

            ExampleScreen1ViewModel::class.java -> {
                ExampleScreen1ViewModel(DummyRepositoryImpl(ServicePool.dummyService)) as T
            }

            SearchViewModel::class.java -> {
                SearchViewModel(SearchRepositoryImpl(ServicePool.searchService)) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }
}
