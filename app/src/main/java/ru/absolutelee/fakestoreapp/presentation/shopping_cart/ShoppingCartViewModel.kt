package ru.absolutelee.fakestoreapp.presentation.shopping_cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.absolutelee.fakestoreapp.data.repository.StoreRepositoryImpl
import ru.absolutelee.fakestoreapp.domain.entity.Product
import ru.absolutelee.fakestoreapp.domain.usecase.ChangeIsCartStatusUseCase
import ru.absolutelee.fakestoreapp.domain.usecase.GetAllProductsUseCase
import ru.absolutelee.fakestoreapp.domain.usecase.GetCartProductsUseCase

class ShoppingCartViewModel : ViewModel() {
    private val repository = StoreRepositoryImpl
    private val getCartProductsUseCase = GetCartProductsUseCase(repository)
    private val changeIsCartStatusUseCase = ChangeIsCartStatusUseCase(repository)

    val state = getCartProductsUseCase()

    fun removeProductFromCart(product: Product){
        viewModelScope.launch {
            changeIsCartStatusUseCase(product)
        }
    }
}