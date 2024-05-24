package ru.absolutelee.fakestoreapp.domain.entity

data class Product (
    val id: Int,
    val title: String,
    val price: Double,
    val rating: Double,
    val ratingCount: Int,
    val imageUrl: String,
    val isAddToCart: Boolean,
    val description: String
)