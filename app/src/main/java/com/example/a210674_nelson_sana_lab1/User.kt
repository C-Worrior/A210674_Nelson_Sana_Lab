package com.example.a210674_nelson_sana_lab1

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class User(
    @DrawableRes val profilePic : Int,
    @StringRes val name : Int,
    @StringRes val lastSeen : Int
)

val users = listOf(
    User(R.drawable.avatar, R.string.user1, R.string.seen2),
    User(R.drawable.mom, R.string.user2, R.string.seen2),
    User(R.drawable.mom, R.string.user3, R.string.seen3),
    User(R.drawable.brother, R.string.user4, R.string.seen4)
)

