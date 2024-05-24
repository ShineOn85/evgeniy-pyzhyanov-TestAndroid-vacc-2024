package ru.absolutelee.fakestoreapp.presentation.shopping_cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.absolutelee.fakestoreapp.R
import ru.absolutelee.fakestoreapp.domain.entity.Product

@Composable
fun ShoppingCartItem(product: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .height(120.dp)
        ) {
            Image(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .height(120.dp),
                painter = painterResource(id = R.drawable.img),
                contentDescription = stringResource(
                    id = R.string.product_image
                )
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = "$${product.price}", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    modifier = Modifier.padding(end = 12.dp),
                    text = product.title,
                    fontSize = 16.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Button(onClick = { }) {
                        Icon(
                            modifier = Modifier.size(16.dp),
                            imageVector = Icons.Default.Delete,
                            contentDescription = stringResource(
                                R.string.delete_icon
                            )
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Remove", fontSize = 12.sp)
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun ShoppingCartItemPreview() {
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
    ShoppingCartItem(product = product)
}