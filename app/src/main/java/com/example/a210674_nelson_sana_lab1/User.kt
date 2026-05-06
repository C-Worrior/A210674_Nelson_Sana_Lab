package com.example.a210674_nelson_sana_lab1

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class User(
    @DrawableRes val profilePic : Int,
    val name : String,
    @StringRes val lastSeen : Int,
)

