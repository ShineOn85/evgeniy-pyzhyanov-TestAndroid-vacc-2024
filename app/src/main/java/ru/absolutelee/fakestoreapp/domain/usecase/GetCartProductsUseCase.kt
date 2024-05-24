package ru.absolutelee.fakestoreapp.domain.usecase

import kotlinx.coroutines.flow.StateFlow
import ru.absolutelee.fakestoreapp.domain.entity.Product
import ru.absolutelee.fakestoreapp.domain.repository.StoreRepository

class GetCartProductsUseCase(private val repository: StoreRepository) {
    operator fun invoke(): StateFlow<List<Product>> {
        return repository.getCartProducts()
    }
}