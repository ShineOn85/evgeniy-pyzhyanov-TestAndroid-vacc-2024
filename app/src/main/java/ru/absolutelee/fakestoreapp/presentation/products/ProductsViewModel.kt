package ru.absolutelee.fakestoreapp.presentation.products

import androidx.lifecycle.ViewModel
import ru.absolutelee.fakestoreapp.data.repository.StoreRepositoryImpl
import ru.absolutelee.fakestoreapp.domain.usecase.GetAllProductsUseCase

class ProductsViewModel(): ViewModel() {

    private val repository = StoreRepositoryImpl()
    private val getAllProductsUseCase = GetAllProductsUseCase(repository)
    val state = getAllProductsUseCase()
}