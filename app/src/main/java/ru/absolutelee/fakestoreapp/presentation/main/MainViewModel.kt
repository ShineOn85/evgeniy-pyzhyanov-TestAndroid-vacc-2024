package ru.absolutelee.fakestoreapp.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.absolutelee.fakestoreapp.data.repository.StoreRepositoryImpl
import ru.absolutelee.fakestoreapp.domain.usecase.AuthUseCase
import ru.absolutelee.fakestoreapp.domain.usecase.GetAuthStateUseCase
import ru.absolutelee.fakestoreapp.domain.usecase.GetCartProductsUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getAuthStateUseCase: GetAuthStateUseCase,
    private val authUseCase: AuthUseCase
) : ViewModel() {


    val state = getAuthStateUseCase()
    fun auth() {
        viewModelScope.launch {
            authUseCase()
        }
    }
}