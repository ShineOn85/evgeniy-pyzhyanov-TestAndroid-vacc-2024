package ru.absolutelee.fakestoreapp.data

import ru.absolutelee.fakestoreapp.data.model.ProductDto
import ru.absolutelee.fakestoreapp.domain.entity.Product

fun ProductDto.mapToProductEntity(): Product {
    return Product(
        id = this.id,
        title = this.title,
        price = this.price,
        rating = this.rating.rate,
        ratingCount = this.rating.count,
        imageUrl = this.imageUrl,
        isAddToCart = false,
        description = this.description
    )
}