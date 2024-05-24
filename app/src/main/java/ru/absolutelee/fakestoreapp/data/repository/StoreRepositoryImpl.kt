package ru.absolutelee.fakestoreapp.data.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.retry
import kotlinx.coroutines.flow.stateIn
import ru.absolutelee.fakestoreapp.data.mapper.mapToProductEntity
import ru.absolutelee.fakestoreapp.data.mergeWith
import ru.absolutelee.fakestoreapp.data.network.ApiFactory
import ru.absolutelee.fakestoreapp.data.network.ApiService
import ru.absolutelee.fakestoreapp.domain.entity.AuthState
import ru.absolutelee.fakestoreapp.domain.entity.Product
import ru.absolutelee.fakestoreapp.domain.repository.StoreRepository
import javax.inject.Inject

class StoreRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : StoreRepository {


    private val scope = CoroutineScope(Dispatchers.Default)

    private val loggedIn = MutableStateFlow(false)

    private val changeProductListFlow = MutableSharedFlow<List<Product>>()

    private val _products = mutableListOf<Product>()
    private val products: List<Product>
        get() = _products.toList()

    private val _cartProductsList = mutableListOf<Product>()
    private val cartProductsList: List<Product>
        get() = _cartProductsList.toList()

    private val changeCartProductEvent = MutableSharedFlow<Unit>()


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
        val productsResponse = apiService.getAllProducts().map {
            it.mapToProductEntity()
        }
        _products.addAll(productsResponse)
        emit(products)
    }.mergeWith(changeProductListFlow)
        .retry {
            delay(2000)
            true
        }
        .catch { }
        .stateIn(
            scope = scope,
            started = SharingStarted.Lazily,
            initialValue = listOf()
        )

    override fun getCartProducts() = flow {
        changeCartProductEvent.emit(Unit)
        changeCartProductEvent.collect {
            emit(cartProductsList)
        }
    }.stateIn(
        scope = scope,
        started = SharingStarted.Eagerly,
        initialValue = cartProductsList
    )


    override fun getProductDetail(product: Product): StateFlow<Product> = flow {
        val product = apiService.getProductDetail(product.id).mapToProductEntity()
        emit(product)
    }.retry {
        delay(2000)
        true
    }
        .catch { }
        .stateIn(
            scope = scope,
            started = SharingStarted.Lazily,
            initialValue = Product(id = 3, "", 1.2, 1.4, 2, "", false, "")
        )

    override suspend fun auth() {
        loggedIn.emit(true)
    }

    override suspend fun changeIsCartStatus(product: Product) {
        if (product.isAddToCart) {
            _cartProductsList.remove(product)
            val newProduct = product.copy(isAddToCart = false)
            val productIndex = _products.indexOf(product)
            _products[productIndex] = newProduct
        } else {
            val newProduct = product.copy(isAddToCart = true)
            _cartProductsList.add(newProduct)
            val productIndex = _products.indexOf(product)
            _products[productIndex] = newProduct

        }
        changeCartProductEvent.emit(Unit)
        changeProductListFlow.emit(products)
    }
}