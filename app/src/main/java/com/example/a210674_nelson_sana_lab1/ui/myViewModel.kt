package com.example.a210674_nelson_sana_lab1.ui

import androidx.lifecycle.ViewModel
import com.example.a210674_nelson_sana_lab1.ui.theme.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MyViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun setName(newUsername: String){
        _uiState.update { currentState ->
            currentState.copy(
                userName = newUsername
            )
        }
    }

    fun comparePassword(userInput: String, actualPassword: String) {

        _uiState.update { currentState ->
            currentState.copy(
                authorise = userInput == actualPassword
            )
        }
    }
}