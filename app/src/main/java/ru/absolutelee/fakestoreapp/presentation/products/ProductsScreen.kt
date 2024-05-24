package ru.absolutelee.fakestoreapp.presentation.products

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.absolutelee.fakestoreapp.domain.entity.Product
import ru.absolutelee.fakestoreapp.presentation.getApplicationComponent

@Composable
fun ProductsScreen(
    onCardClick: (Product) -> Unit,
) {

    val component = getApplicationComponent()
    val viewModel: ProductsViewModel = viewModel(factory = component.getViewModelFactory())
    val state = viewModel.state.collectAsState()


    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(bottom = 80.dp)
    ) {
        items(items = state.value, key = { it.id }) { product ->
            ProductItem(
                product = product,
                onCardClick,
                onChangeCartStatusClick = {
                    viewModel.changeCartStatus(it)
                }
            )
        }
    }
}
