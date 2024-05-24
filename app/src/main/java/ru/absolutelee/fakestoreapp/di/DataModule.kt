package ru.absolutelee.fakestoreapp.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.absolutelee.fakestoreapp.data.network.ApiFactory
import ru.absolutelee.fakestoreapp.data.network.ApiService
import ru.absolutelee.fakestoreapp.data.repository.StoreRepositoryImpl
import ru.absolutelee.fakestoreapp.domain.repository.StoreRepository

@Module
interface DataModule {
    @ApplicationScope
    @Binds
    fun bindRepository(impl: StoreRepositoryImpl): StoreRepository

    companion object {
        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}