package ru.absolutelee.fakestoreapp.domain.entity

sealed class AuthState{

    object Authorized: AuthState()
    object Unauthorized: AuthState()

}