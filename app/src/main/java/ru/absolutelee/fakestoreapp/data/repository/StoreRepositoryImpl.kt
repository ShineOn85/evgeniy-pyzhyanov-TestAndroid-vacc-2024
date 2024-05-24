package ru.absolutelee.fakestoreapp.data.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import ru.absolutelee.fakestoreapp.data.mapToProductEntity
import ru.absolutelee.fakestoreapp.data.network.ApiFactory
import ru.absolutelee.fakestoreapp.domain.entity.AuthState
import ru.absolutelee.fakestoreapp.domain.entity.Product
import ru.absolutelee.fakestoreapp.domain.repository.StoreRepository

class StoreRepositoryImpl() : StoreRepository {

    private val apiService = ApiFactory.apiService

    private val scope = CoroutineScope(Dispatchers.Default)

    private val loggedIn = MutableStateFlow(false)

    override fun getAuthState(): StateFlow<AuthState> {
        return flow {
            loggedIn.collect {
                val authState = if (loggedIn.value) AuthState.Authorized else AuthState.Unauthorized
                emit(authState)
            }
        }.stateIn(
            scope = scope,
            started = SharingStarted.Lazily,
            initialValue = AuthState.Unauthorized
        )
    }

    override fun getAllProducts(): StateFlow<List<Product>> = flow {
        val products = apiService.getAllProducts().map {
            it.mapToProductEntity()
        }
        emit(products)
    }.catch { }
        .stateIn(
            scope = scope,
            started = SharingStarted.Lazily,
            initialValue = listOf()
        )

    override fun getProductDetail(product: Product): StateFlow<Product> = flow {
        val product = apiService.getProductDetail(product.id).mapToProductEntity()
        emit(product)
    }.stateIn(
        scope = scope,
        started = SharingStarted.Lazily,
        initialValue = Product(id = 3, "", 1.2, 1.4, 2, "", false, "")
    )

    override suspend fun auth() {
        loggedIn.emit(true)
    }

    override suspend fun addToCart(product: Product) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFromCart(product: Product) {
        TODO("Not yet implemented")
    }
}