package ru.absolutelee.fakestoreapp.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.absolutelee.fakestoreapp.data.repository.StoreRepositoryImpl
import ru.absolutelee.fakestoreapp.domain.usecase.AuthUseCase
import ru.absolutelee.fakestoreapp.domain.usecase.GetAuthStateUseCase
import ru.absolutelee.fakestoreapp.domain.usecase.GetCartProductsUseCase

class MainViewModel: ViewModel() {
    private val repository = StoreRepositoryImpl
    private val getAuthStateUseCase  = GetAuthStateUseCase(repository)
    private val authUseCase  = AuthUseCase(repository)

    val state = getAuthStateUseCase()
    fun auth() {
        viewModelScope.launch {
            authUseCase()
        }
    }
}