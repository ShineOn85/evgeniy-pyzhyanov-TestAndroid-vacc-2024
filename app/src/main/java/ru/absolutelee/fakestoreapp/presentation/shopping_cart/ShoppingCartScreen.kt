package ru.absolutelee.fakestoreapp.presentation.shopping_cart

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.absolutelee.fakestoreapp.domain.entity.Product
import kotlin.random.Random

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCartScreen(products: List<Product>) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .height(40.dp)
                    .clip(shape = RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp)),
                title = {
                    Column {
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Cart", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.weight(1f))
                            Text(text = "4 items", fontSize = 20.sp)
                            Spacer(modifier = Modifier.width(12.dp))
                        }
                    }

                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues),
            contentPadding = PaddingValues(bottom = 80.dp)
        ) {
            items(
                items = products,
                key = { it.id }
            ) {
                ShoppingCartItem(product = it)
            }
        }
        Spacer(modifier = Modifier.height(80.dp))
    }
}

@Composable
@Preview
fun ShoppingCartScreenPreview() {
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
                    description = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday"
                )
            )
        }
    }
    ShoppingCartScreen(products)
}