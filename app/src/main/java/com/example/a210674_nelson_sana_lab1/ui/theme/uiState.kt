package com.example.a210674_nelson_sana_lab1.ui.theme

import com.example.a210674_nelson_sana_lab1.Circle
import com.example.a210674_nelson_sana_lab1.Community
import com.example.a210674_nelson_sana_lab1.NameSuggestion
import com.example.a210674_nelson_sana_lab1.User
import com.example.a210674_nelson_sana_lab1.Suggestion

data class UiState(
    val userName : String = "",
    val password : String = "pass123",
    val authorise: Boolean = false,

    val userList : List<User> = emptyList(),
    val circleList : List<Circle> = emptyList(),
    val communityList : List<Community> = emptyList(),
    val suggestionList : List<Suggestion> = NameSuggestion


)