package ru.absolutelee.fakestoreapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.absolutelee.fakestoreapp.domain.entity.Product

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    productsScreenContent: @Composable () -> Unit,
    productDetailScreenContent: @Composable (Product) -> Unit,
    shoppingCartScreenContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.HomeScreen.route,
    ) {
        homeScreenNavGraph(
            productsScreenContent = productsScreenContent,
            productDetailScreenContent = productDetailScreenContent
        )
        composable(route = Screen.ShoppingCartScreen.route) {
            shoppingCartScreenContent()
        }
    }
}