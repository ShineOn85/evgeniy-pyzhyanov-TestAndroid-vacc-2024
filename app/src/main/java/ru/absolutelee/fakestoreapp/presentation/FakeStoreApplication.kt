package ru.absolutelee.fakestoreapp.presentation

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import ru.absolutelee.fakestoreapp.di.ApplicationComponent
import ru.absolutelee.fakestoreapp.di.DaggerApplicationComponent

class FakeStoreApplication : Application() {
    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}

@Composable
fun getApplicationComponent(): ApplicationComponent {
    return (LocalContext.current.applicationContext as FakeStoreApplication).component
}