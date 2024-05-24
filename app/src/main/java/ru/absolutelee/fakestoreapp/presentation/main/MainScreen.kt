package ru.absolutelee.fakestoreapp.presentation.main

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.absolutelee.fakestoreapp.domain.entity.Product
import ru.absolutelee.fakestoreapp.navigation.AppNavGraph
import ru.absolutelee.fakestoreapp.navigation.rememberNavigationState
import ru.absolutelee.fakestoreapp.presentation.products.ProductsScreen
import kotlin.random.Random

@Preview(showBackground = true)
@Composable
fun MainScreen() {

    val navigationState = rememberNavigationState()

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by
                navigationState.navHostController.currentBackStackEntryAsState()

                val items = listOf(
                    NavigationItem.Home,
                    NavigationItem.ShoppingCart,
                )

                items.forEach { item ->

                    val selected = navBackStackEntry?.destination?.hierarchy?.any {
                        it.route == item.screen.route
                    } ?: false

                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            if (!selected) {
                                navigationState.navigateTo(item.screen.route)
                            }
                        },
                        icon = { Icon(imageVector = item.icon, contentDescription = null) },
                        label = { Text(text = stringResource(id = item.titleResId)) }
                    )
                }
            }
        }
    ) {_ ->

        AppNavGraph(
            navHostController = navigationState.navHostController,
            productsScreenContent = {
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
            },
            productDetailScreenContent = { Text(text = "detail")},
            shoppingCartScreenContent = { Text(text = "cart")}
        )
    }
}