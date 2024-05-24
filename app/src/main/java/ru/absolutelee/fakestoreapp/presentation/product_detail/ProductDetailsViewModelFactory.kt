package ru.absolutelee.fakestoreapp.presentation.product_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.absolutelee.fakestoreapp.domain.entity.Product

class ProductDetailsViewModelFactory(
    private val product: Product
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductDetailViewModel(product) as T
    }
}