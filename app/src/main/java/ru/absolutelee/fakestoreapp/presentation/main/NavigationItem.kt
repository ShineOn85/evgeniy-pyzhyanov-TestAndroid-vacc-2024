package ru.absolutelee.fakestoreapp.presentation.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import ru.absolutelee.fakestoreapp.R
import ru.absolutelee.fakestoreapp.navigation.Screen

sealed class NavigationItem(
    val screen: Screen,
    val titleResId: Int,
    val icon: ImageVector
) {

    data object Home : NavigationItem(
        screen = Screen.HomeScreen,
        R.string.home,
        Icons.Outlined.Home
    )

    data object ShoppingCart : NavigationItem(
        screen = Screen.ShoppingCartScreen,
        R.string.shopping_cart,
        Icons.Outlined.ShoppingCart
    )


}