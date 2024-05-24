package ru.absolutelee.fakestoreapp.presentation.main

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.absolutelee.fakestoreapp.R

@Composable
fun LoginScreen(onLoginClick: () -> Unit) {
    var email by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }

    var isEmailError by rememberSaveable {
        mutableStateOf(false)
    }

    var isPasswordError by rememberSaveable {
        mutableStateOf(false)
    }

    fun isEmailValid(email: String) {
        isEmailError = !Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isPasswordValid(password: String) {
        isPasswordError = password.length < 4
    }

    Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painterResource(id = R.drawable.login),
                contentDescription = stringResource(R.string.welcome_image)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(R.string.welcome),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                value = email,
                onValueChange = {
                    isEmailValid(it)
                    email = it
                },
                label = {
                    Text(text = stringResource(R.string.email_address))
                },
                singleLine = true,
                isError = isEmailError,
                supportingText = {
                    if (isEmailError) {
                        Text(text = stringResource(R.string.invalid_email))
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                value = password,
                onValueChange = {
                    isPasswordValid(it)
                    password = it
                },
                visualTransformation = PasswordVisualTransformation(),
                label = {
                    Text(text = stringResource(R.string.password))
                },
                singleLine = true,
                isError = isPasswordError,
                supportingText = {
                    if (isPasswordError) {
                        Text(text = stringResource(R.string.password_must_contain_at_least_4_characters))
                    }
                }
            )
            Spacer(modifier = Modifier.height(100.dp))
            Button(
                onClick = {
                    if (!isEmailError && !isPasswordError) {
                        onLoginClick()
                    }
                },
                enabled = email.isNotEmpty() && password.isNotEmpty() && !isEmailError && !isPasswordError
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 24.dp),
                    text = stringResource(R.string.login)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.clickable { },
                text = stringResource(R.string.or_sign_up),
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground,
                textDecoration = TextDecoration.Underline
            )
        }
    }

}

@Composable
@Preview
fun LoginScreenPreview() {
    LoginScreen {

    }
}