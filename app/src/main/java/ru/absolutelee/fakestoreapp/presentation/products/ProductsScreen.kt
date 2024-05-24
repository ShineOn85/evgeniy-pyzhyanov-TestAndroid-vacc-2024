package ru.absolutelee.fakestoreapp.presentation.products

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ru.absolutelee.fakestoreapp.domain.entity.Product
import kotlin.random.Random

@Composable
fun ProductsScreen(products: List<Product>) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(items = products, key = { it.id }) {
            ProductItem(product = it)
        }
    }
}

@Composable
@Preview
fun ProductScreenPreview() {
    val products = mutableListOf<Product>().apply {
        for (i in 0..10) {
            add(
                Product(
                    id = i,
                    title = "title $i",
                    price = (i * 10).toDouble(),
                    rating = i.toDouble() / 2f,
                    ratingCount = i * 15,
                    imageUrl = "",
                    isAddToCart = Random.nextBoolean(),
                    description = "description $i"
                )
            )
        }
    }
    ProductsScreen(products = products)
}