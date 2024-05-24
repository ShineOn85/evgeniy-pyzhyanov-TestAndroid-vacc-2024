package ru.absolutelee.fakestoreapp.presentation.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.absolutelee.fakestoreapp.data.repository.StoreRepositoryImpl
import ru.absolutelee.fakestoreapp.domain.entity.Product
import ru.absolutelee.fakestoreapp.domain.usecase.AddToCartUseCase
import ru.absolutelee.fakestoreapp.domain.usecase.GetAllProductsUseCase

class ProductsViewModel() : ViewModel() {

    private val repository = StoreRepositoryImpl()
    private val getAllProductsUseCase = GetAllProductsUseCase(repository)
    private val addToCartUseCase = AddToCartUseCase(repository)

    val state = getAllProductsUseCase()

    fun addToCart(product: Product) {
        viewModelScope.launch {
            addToCartUseCase(product)
        }
    }


}