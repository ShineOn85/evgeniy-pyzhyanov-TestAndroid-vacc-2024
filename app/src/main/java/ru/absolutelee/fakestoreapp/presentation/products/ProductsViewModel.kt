package ru.absolutelee.fakestoreapp.presentation.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.absolutelee.fakestoreapp.domain.entity.Product
import ru.absolutelee.fakestoreapp.domain.usecase.ChangeIsCartStatusUseCase
import ru.absolutelee.fakestoreapp.domain.usecase.GetAllProductsUseCase
import javax.inject.Inject

class ProductsViewModel @Inject constructor(
    getAllProductsUseCase: GetAllProductsUseCase,
    private val changeIsCartStatusUseCase: ChangeIsCartStatusUseCase
) : ViewModel() {

    val state = getAllProductsUseCase()

    fun changeCartStatus(product: Product) {
        viewModelScope.launch {
            changeIsCartStatusUseCase(product)
        }
    }


}