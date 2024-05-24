package ru.absolutelee.fakestoreapp.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.absolutelee.fakestoreapp.presentation.main.MainViewModel
import ru.absolutelee.fakestoreapp.presentation.product_detail.ProductDetailViewModel
import ru.absolutelee.fakestoreapp.presentation.products.ProductsViewModel
import ru.absolutelee.fakestoreapp.presentation.shopping_cart.ShoppingCartViewModel

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @Binds
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @IntoMap
    @ViewModelKey(ProductsViewModel::class)
    @Binds
    fun bindProductsViewModel(viewModel: ProductsViewModel): ViewModel

    @IntoMap
    @ViewModelKey(ShoppingCartViewModel::class)
    @Binds
    fun bindShoppingCartViewModel(viewModel: ShoppingCartViewModel): ViewModel
}