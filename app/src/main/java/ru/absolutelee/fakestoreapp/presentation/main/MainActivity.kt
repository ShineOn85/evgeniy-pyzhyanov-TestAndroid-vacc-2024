package ru.absolutelee.fakestoreapp.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.absolutelee.fakestoreapp.domain.entity.AuthState
import ru.absolutelee.fakestoreapp.ui.theme.FakeStoreAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FakeStoreAppTheme(dynamicColor = false) {
                val viewModel = viewModel(MainViewModel::class)
                val state = viewModel.state.collectAsState()

                when (state.value) {
                    is AuthState.Authorized -> {
                        MainScreen()
                    }

                    AuthState.Unauthorized -> {
                        LoginScreen(onLoginClick = {
                            viewModel.auth()
                        })
                    }
                }
            }
        }
    }
}

