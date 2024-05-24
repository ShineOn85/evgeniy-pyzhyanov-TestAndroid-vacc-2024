package ru.absolutelee.fakestoreapp.domain.usecase

import kotlinx.coroutines.flow.StateFlow
import ru.absolutelee.fakestoreapp.domain.entity.AuthState
import ru.absolutelee.fakestoreapp.domain.repository.StoreRepository

class GetAuthStateUseCase(
    private val repository: StoreRepository
) {
    operator fun invoke(): StateFlow<AuthState> {
        return repository.getAuthState()
    }
}