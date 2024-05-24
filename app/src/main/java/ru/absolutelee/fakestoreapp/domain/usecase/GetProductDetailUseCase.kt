package ru.absolutelee.fakestoreapp.domain.usecase

import kotlinx.coroutines.flow.StateFlow
import ru.absolutelee.fakestoreapp.domain.entity.Product
import ru.absolutelee.fakestoreapp.domain.repository.StoreRepository

class GetProductDetailUseCase(
    private val repository: StoreRepository
) {
    operator fun invoke(product: Product): StateFlow<Product>{
        return repository.getProductDetail(product)
    }
}