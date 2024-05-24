package ru.absolutelee.fakestoreapp.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.absolutelee.fakestoreapp.presentation.product_detail.ProductDetailViewModel

@Module
interface ProductDetailViewModel {
    @IntoMap
    @ViewModelKey(ProductDetailViewModel::class)
    @Binds
    fun bindProductDetailViewModel(viewModel: ProductDetailViewModel): ViewModel
}