package ru.absolutelee.fakestoreapp.domain.repository

import kotlinx.coroutines.flow.StateFlow
import ru.absolutelee.fakestoreapp.domain.entity.AuthState
import ru.absolutelee.fakestoreapp.domain.entity.Product

interface StoreRepository {

    fun getAuthState(): StateFlow<AuthState>

    fun getAllProducts(): StateFlow<List<Product>>

    fun getProductDetail(product: Product): StateFlow<Product>

    suspend fun auth()

    suspend fun changeIsCartStatus(product: Product)

    suspend fun deleteFromCart(product: Product)
}