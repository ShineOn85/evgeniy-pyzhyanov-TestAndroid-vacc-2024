package ru.absolutelee.fakestoreapp.presentation.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.absolutelee.fakestoreapp.data.repository.StoreRepositoryImpl
import ru.absolutelee.fakestoreapp.domain.entity.Product
import ru.absolutelee.fakestoreapp.domain.usecase.ChangeIsCartStatusUseCase
import ru.absolutelee.fakestoreapp.domain.usecase.GetAllProductsUseCase
import ru.absolutelee.fakestoreapp.domain.usecase.GetCartProductsUseCase

class ProductsViewModel() : ViewModel() {

    private val repository = StoreRepositoryImpl
    private val getAllProductsUseCase = GetAllProductsUseCase(repository)
    private val changeIsCartStatusUseCase = ChangeIsCartStatusUseCase(repository)
    private val getCartProductUseCase = GetCartProductsUseCase(repository)

    val state = getAllProductsUseCase()

    fun changeCartStatus(product: Product) {
        viewModelScope.launch {
            changeIsCartStatusUseCase(product)
        }
    }


}