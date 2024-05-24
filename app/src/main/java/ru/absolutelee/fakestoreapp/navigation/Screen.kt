package ru.absolutelee.fakestoreapp.navigation

import android.net.Uri
import com.google.gson.Gson
import ru.absolutelee.fakestoreapp.domain.entity.Product

sealed class Screen(
    val route: String
) {

    data object HomeScreen : Screen(ROUTE_HOME)
    data object ShoppingCartScreen : Screen(ROUTE_SHOPPING_CART)
    data object ProductDetailScreen : Screen(ROUTE_PRODUCT_DETAIL)
    {

        private const val ROUTE_FOR_ID = "comments_screen"

        fun getRouteWithArgs(product: Product): String {
            val productJson = Gson().toJson(product)
            return "$ROUTE_FOR_ID/${productJson.encode()}"
        }
    }

    companion object {

        const val KEY_PRODUCT = "product"

        private const val ROUTE_HOME = "home_screen"
        private const val ROUTE_SHOPPING_CART = "shopping_cart_screen"
        private const val ROUTE_PRODUCT_DETAIL = "product_detail_screen/{$KEY_PRODUCT}"
    }
}

fun String.encode(): String{
    return Uri.encode(this)
}