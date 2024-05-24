package ru.absolutelee.fakestoreapp.di

import dagger.BindsInstance
import dagger.Subcomponent
import ru.absolutelee.fakestoreapp.domain.entity.Product
import ru.absolutelee.fakestoreapp.presentation.ViewModelFactory

@Subcomponent(
    modules = [
        ProductDetailViewModel::class
    ]
)
interface ProductDetailScreenComponent {
    fun getViewModelFactory(): ViewModelFactory

    @Subcomponent.Factory
    interface Factory {

        fun create(
            @BindsInstance product: Product
        ): ProductDetailScreenComponent
    }
}