package ru.absolutelee.fakestoreapp.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.absolutelee.fakestoreapp.data.repository.StoreRepositoryImpl
import ru.absolutelee.fakestoreapp.domain.usecase.GetAuthStateUseCase

class MainViewModel: ViewModel() {
    private val repository = StoreRepositoryImpl()
    private val getAuthStateUseCase  = GetAuthStateUseCase(repository)

    val state = getAuthStateUseCase()

    fun auth() {
        viewModelScope.launch {
            repository.auth()
        }
    }
}