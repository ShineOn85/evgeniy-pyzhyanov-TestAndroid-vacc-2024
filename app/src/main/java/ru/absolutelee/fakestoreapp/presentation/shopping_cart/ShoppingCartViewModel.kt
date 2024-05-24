package ru.absolutelee.fakestoreapp.presentation.shopping_cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.absolutelee.fakestoreapp.domain.entity.Product
import ru.absolutelee.fakestoreapp.domain.usecase.ChangeIsCartStatusUseCase
import ru.absolutelee.fakestoreapp.domain.usecase.GetCartProductsUseCase
import javax.inject.Inject

class ShoppingCartViewModel @Inject constructor(
    getCartProductsUseCase: GetCartProductsUseCase,
    private val changeIsCartStatusUseCase: ChangeIsCartStatusUseCase
) : ViewModel() {

    val state = getCartProductsUseCase()

    fun removeProductFromCart(product: Product) {
        viewModelScope.launch {
            changeIsCartStatusUseCase(product)
        }
    }
}