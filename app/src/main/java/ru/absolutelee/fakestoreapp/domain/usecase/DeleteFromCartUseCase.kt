package ru.absolutelee.fakestoreapp.domain.usecase

import ru.absolutelee.fakestoreapp.domain.entity.Product
import ru.absolutelee.fakestoreapp.domain.repository.StoreRepository

class DeleteFromCartUseCase (
    private val repository: StoreRepository
){
    suspend operator fun invoke(product: Product){
        repository.deleteFromCart(product)
    }
}