package ru.absolutelee.fakestoreapp.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.absolutelee.fakestoreapp.presentation.ViewModelFactory


@ApplicationScope
@Component(
    modules = [ViewModelModule::class, DataModule::class]
)
interface ApplicationComponent {
    fun getViewModelFactory(): ViewModelFactory

    fun getProductDetailScreenComponentFactory(): ProductDetailScreenComponent.Factory

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance context: Context
        ): ApplicationComponent
    }
}