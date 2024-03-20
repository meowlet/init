package com.meow.fore.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.meow.fore.auth.Repository

class HomeScreenViewModel(
    private val repository: Repository = Repository()
) : ViewModel() {
    var viewState by mutableStateOf(HomeScreenViewState())
        private set

    fun onTextChanged(text: String) {
        viewState = viewState.copy(text = text)
    }
}

data class HomeScreenViewState(
    val isLoading: Boolean = false,
    val text: String = ""
)