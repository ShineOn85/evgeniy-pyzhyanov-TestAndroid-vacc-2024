package ru.absolutelee.fakestoreapp.presentation.products

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import ru.absolutelee.fakestoreapp.R
import ru.absolutelee.fakestoreapp.domain.entity.Product

@Composable
fun ProductItem(
    product: Product,
    onCardClick: (Product) -> Unit,
    onAddToCardClick: (Product) -> Unit
) {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .width(200.dp)
            .padding(8.dp)
            .clickable {
                onCardClick(product)
            },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background)
    ) {

        AsyncImage(
            modifier = Modifier.height(210.dp),
            model = product.imageUrl,
            contentDescription = stringResource(R.string.product_image),
            contentScale = ContentScale.FillBounds
        )
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = "Price: $${product.price}",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = product.title,
                maxLines = 2
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    imageVector = Icons.Default.Star,
                    contentDescription = stringResource(R.string.rating_icon),
                    tint = colorResource(id = R.color.dark_yellow)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = product.rating.toString(), fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "• ${product.ratingCount} count")
            }
            Spacer(modifier = Modifier.height(8.dp))
            AddToCartButton(onAddToCardClick)
        }


    }
}

@Composable
fun AddToCartButton(onAddToCardClick: (Product) -> Unit) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = { onAddToCardClick }) {
        Icon(
            modifier = Modifier.size(16.dp),
            imageVector = Icons.Outlined.ShoppingCart, contentDescription = stringResource(
                R.string.icon_cart
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = stringResource(id = R.string.add_to_cart))
    }
}

@Composable
@Preview
fun ProductItemPreview() {
    val product = Product(
        id = 1,
        title = "Mens Casual Premium Slim Fit T-Shirt",
        price = 2485.5,
        rating = 4.7,
        ratingCount = 543,
        imageUrl = "",
        isAddToCart = false,
        description = ""
    )
    ProductItem(product = product, onCardClick = {}, onAddToCardClick = {})
}