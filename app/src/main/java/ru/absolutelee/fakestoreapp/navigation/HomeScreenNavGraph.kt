package ru.absolutelee.fakestoreapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.google.gson.Gson
import ru.absolutelee.fakestoreapp.domain.entity.Product
import ru.absolutelee.fakestoreapp.navigation.Screen.Companion.KEY_PRODUCT


fun NavGraphBuilder.homeScreenNavGraph(
    productsScreenContent: @Composable () -> Unit,
    productDetailScreenContent: @Composable (Product) -> Unit
) {
    navigation(
        startDestination = Screen.ProductsScreen.route,
        route = Screen.HomeScreen.route
    ) {
        composable(route = Screen.ProductsScreen.route) {
            productsScreenContent()
        }
        composable(
            route = Screen.ProductDetailScreen.route,
            arguments = listOf(
                navArgument(KEY_PRODUCT) {
                    type = NavType.StringType
                },
            )
        ) {
            val productJson = it.arguments?.getString(KEY_PRODUCT) ?: ""
            val product = Gson().fromJson(productJson, Product::class.java)
            productDetailScreenContent(product)
        }
    }
}