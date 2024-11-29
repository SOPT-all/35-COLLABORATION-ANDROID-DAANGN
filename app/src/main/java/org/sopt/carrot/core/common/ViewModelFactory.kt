package org.sopt.carrot.core.common

import org.sopt.carrot.data.repositoryimpl.ProductDetailRepositoryImpl
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import org.sopt.carrot.data.ServicePool
import org.sopt.carrot.data.repositoryimpl.CategoryRepositoryImpl
import org.sopt.carrot.data.repositoryimpl.DummyRepositoryImpl
import org.sopt.carrot.data.repositoryimpl.SearchRepositoryImpl
import org.sopt.carrot.data.repositoryimpl.UserRepositoryImpl
import org.sopt.carrot.presentation.ExampleScreen1.ExampleScreen1ViewModel
import org.sopt.carrot.presentation.productDetailScreen.ProductDetailViewModel
import org.sopt.carrot.presentation.category.CategoryViewmodel
import org.sopt.carrot.presentation.sellerProfile.SellerProfileViewModel
import org.sopt.carrot.presentation.titleSearchScreen.SearchViewModel


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

            SearchViewModel::class.java -> {
                SearchViewModel(SearchRepositoryImpl(ServicePool.searchService)) as T
            }

            ProductDetailViewModel::class.java -> {
                ProductDetailViewModel(
                    ProductDetailRepositoryImpl(ServicePool.productService),
                    UserRepositoryImpl(ServicePool.userService)
                ) as T
            }

            SellerProfileViewModel::class.java -> {
                SellerProfileViewModel(
                    UserRepositoryImpl(ServicePool.userService)
                ) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }
}
