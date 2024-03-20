package com.meow.fore.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeScreenViewModel: HomeScreenViewModel? = null
) {
    val viewState = homeScreenViewModel?.viewState ?: HomeScreenViewState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {
        TextField(
            value = viewState.text,
            onValueChange = { homeScreenViewModel?.onTextChanged(it) },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
            ),
            placeholder = { Text(text = "Email", style = MaterialTheme.typography.titleLarge) },
            textStyle = MaterialTheme.typography.titleLarge,
            singleLine = true
        )
        TextField(
                value = viewState.text,
        onValueChange = { homeScreenViewModel?.onTextChanged(it) },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
        ),
        placeholder = { Text(text = "Email", style = MaterialTheme.typography.titleLarge) },
        textStyle = MaterialTheme.typography.titleLarge,
        singleLine = true
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}