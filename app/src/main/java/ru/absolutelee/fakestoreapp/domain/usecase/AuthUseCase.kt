package ru.absolutelee.fakestoreapp.domain.usecase

import ru.absolutelee.fakestoreapp.domain.repository.StoreRepository
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val repository: StoreRepository
) {
    suspend operator fun invoke() {
        repository.auth()
    }
}