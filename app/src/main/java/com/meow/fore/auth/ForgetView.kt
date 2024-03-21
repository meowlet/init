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
fun ForgetPasswordScreen(
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
            text = "How ignorant!",
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )
        Text(text = "Enter your Email",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start)
        Spacer(modifier = Modifier.size(24.dp))
        TextField(
            value = authUiState.emailReset,
            onValueChange = { viewModel?.onEmailResetChange(it) },
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
        //error field
        if (authUiState.resetPasswordError.isNotEmpty()) {
            Spacer(modifier = Modifier.size(24.dp))
            Text(
                text = authUiState.resetPasswordError,
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
                viewModel?.resetPassword(context){

                }
            }) {
            Text(text = "Sign In",
                style = MaterialTheme.typography.titleMedium)
        }
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = "Remember Password?",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.clickable {
                onNavigateToSignIn.invoke()
            })
    }
}

@Preview
@Composable
fun ForgetPassPreview() {
    ForgetPasswordScreen()
}