package com.meow.fore.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SignUpScreen(
    viewModel: AuthViewModel? = null,
    onNavigateToSignIn: () -> Unit = {}
) {

    val authUiState = viewModel?.authUiState ?: AuthUiState()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Create Account",
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.size(16.dp))
        TextField(
            value = authUiState.emailSignUp,
            onValueChange = { viewModel?.onEmailSignUpChange(it) },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
            ),
            placeholder = {
                Text(
                    text = "Email Address",
                    style = MaterialTheme.typography.titleMedium
                )
            },
            textStyle = MaterialTheme.typography.titleMedium,
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(16.dp))
        TextField(
            value = authUiState.usernameSignUp,
            onValueChange = { viewModel?.onUsernameSignUpChange(it) },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
            ),
            placeholder = { Text(text = "Username", style = MaterialTheme.typography.titleMedium) },
            textStyle = MaterialTheme.typography.titleMedium,
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(16.dp))
        TextField(
            value = authUiState.passwordSignUp,
            onValueChange = { viewModel?.onPassswordSignUpChange(it) },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
            ),
            placeholder = { Text(text = "Password", style = MaterialTheme.typography.titleMedium) },
            textStyle = MaterialTheme.typography.titleMedium,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.size(16.dp))
        TextField(
            value = authUiState.confirmPasswordSignUp,
            onValueChange = { viewModel?.onConfirmPasswordSignUpChange(it) },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
            ),
            placeholder = {
                Text(
                    text = "Re-write Password",
                    style = MaterialTheme.typography.titleMedium
                )
            },
            textStyle = MaterialTheme.typography.titleMedium,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        //error field
        if (authUiState.signUpError.isNotEmpty()) {
            Spacer(modifier = Modifier.size(24.dp))
            Text(
                text = authUiState.signUpError,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Red,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.size(16.dp))
        }
        Spacer(modifier = Modifier.size(24.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            onClick = {
                viewModel?.signUp(context) {
                    viewModel.signOut()
                    onNavigateToSignIn.invoke()
                }
            }) {
            Text(text = "Sign Up",
                style = MaterialTheme.typography.titleMedium)
        }
        Spacer(modifier = Modifier.size(24.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Already have an account?")
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = "Sign In",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.primary,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                    onNavigateToSignIn.invoke()
                })
        }
    }
}

@Preview
@Composable
fun SignUpPreview() {
    SignUpScreen()
}