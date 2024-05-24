package ru.absolutelee.fakestoreapp.presentation.product_detail

import androidx.lifecycle.ViewModel
import ru.absolutelee.fakestoreapp.domain.entity.Product
import ru.absolutelee.fakestoreapp.domain.usecase.GetProductDetailUseCase
import javax.inject.Inject

class ProductDetailViewModel @Inject constructor(
    product: Product,
    getProductDetailUseCase: GetProductDetailUseCase
) : ViewModel() {

    val state = getProductDetailUseCase(product)
}