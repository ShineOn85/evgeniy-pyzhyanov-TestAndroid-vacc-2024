package ru.absolutelee.fakestoreapp.domain.usecase

import ru.absolutelee.fakestoreapp.domain.repository.StoreRepository

class AuthUseCase(private val repository: StoreRepository) {
    suspend operator fun invoke(){
        repository.auth()
    }
}