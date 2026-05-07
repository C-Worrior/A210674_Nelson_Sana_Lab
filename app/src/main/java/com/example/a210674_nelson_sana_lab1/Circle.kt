package com.example.a210674_nelson_sana_lab1

import androidx.annotation.DrawableRes

data class Circle(
    @DrawableRes val photo : Int,
    val circleName : String,
)

data class Suggestion(
    val name: String
)

val NameSuggestion = listOf(
    Suggestion("Family"),
    Suggestion("Friends"),
    Suggestion("Extended Family"),
    Suggestion("Special Someone"),
    Suggestion("Carpool"),
    Suggestion("Siblings"),
    Suggestion("Field trip group"),
    Suggestion("Vacation group"),
    Suggestion("Babysitter")
)