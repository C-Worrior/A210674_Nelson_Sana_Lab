package com.example.a210674_nelson_sana_lab1

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class User(
    @DrawableRes val profilePic : Int,
    val name : String,
    @StringRes val lastSeen : Int,
)

val UserSuggestionList = listOf(
    User(R.drawable.mom, "Mom", R.string.seen2),
    User(R.drawable.dad, "Dad", R.string.seen3),
    User(R.drawable.brother, "Brother", R.string.seen4),
)
