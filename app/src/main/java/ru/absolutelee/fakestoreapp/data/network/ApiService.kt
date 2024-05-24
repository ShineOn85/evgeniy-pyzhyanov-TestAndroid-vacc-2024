package ru.absolutelee.fakestoreapp.data.network

import retrofit2.http.GET
import retrofit2.http.Path
import ru.absolutelee.fakestoreapp.data.model.ProductDto
import ru.absolutelee.fakestoreapp.data.model.ResponseDto

interface ApiService {

    @GET("products")
    suspend fun getAllProducts(): ResponseDto

    @GET("products/{id}")
    suspend fun getProductDetail(@Path("id") id: Int): ProductDto
}