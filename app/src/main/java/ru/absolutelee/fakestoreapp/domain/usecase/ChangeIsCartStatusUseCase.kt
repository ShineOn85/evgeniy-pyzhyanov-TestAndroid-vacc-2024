package ru.absolutelee.fakestoreapp.domain.usecase

import ru.absolutelee.fakestoreapp.domain.entity.Product
import ru.absolutelee.fakestoreapp.domain.repository.StoreRepository
import javax.inject.Inject

class ChangeIsCartStatusUseCase @Inject constructor (
    private val repository: StoreRepository
){
    suspend operator fun invoke(product: Product){
        repository.changeIsCartStatus(product)
    }
}