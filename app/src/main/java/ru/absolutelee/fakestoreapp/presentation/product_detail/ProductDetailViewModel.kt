package ru.absolutelee.fakestoreapp.presentation.product_detail

import androidx.lifecycle.ViewModel
import ru.absolutelee.fakestoreapp.data.repository.StoreRepositoryImpl
import ru.absolutelee.fakestoreapp.domain.entity.Product
import ru.absolutelee.fakestoreapp.domain.usecase.GetProductDetailUseCase

class ProductDetailViewModel(product: Product): ViewModel() {

    private val repository = StoreRepositoryImpl()
    private val getProductDetailUseCase = GetProductDetailUseCase(repository)
    val state = getProductDetailUseCase(product)
}