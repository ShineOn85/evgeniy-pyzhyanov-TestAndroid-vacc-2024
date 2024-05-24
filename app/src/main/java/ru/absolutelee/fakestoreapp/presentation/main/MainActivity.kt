package ru.absolutelee.fakestoreapp.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.absolutelee.fakestoreapp.domain.entity.Product
import ru.absolutelee.fakestoreapp.presentation.products.ProductsScreen
import ru.absolutelee.fakestoreapp.ui.theme.FakeStoreAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FakeStoreAppTheme(dynamicColor = false) {
                MainScreen()
            }
        }
    }
}

