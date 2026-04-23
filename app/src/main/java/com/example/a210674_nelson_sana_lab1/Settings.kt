package com.example.a210674_nelson_sana_lab1

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddAlert
import androidx.compose.material.icons.filled.BuildCircle
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.DirectionsCarFilled
import androidx.compose.material.icons.filled.EditLocation
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Flight
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.graphics.vector.ImageVector

class Setting(
    @StringRes val type: Int,
    val icon: ImageVector
)

val settings = listOf(
    Setting(R.string.notification, Icons.Default.AddAlert),
    Setting(R.string.location, Icons.Default.EditLocation),
    Setting(R.string.management, Icons.Default.BuildCircle),
    Setting(R.string.add, Icons.Default.PersonAdd),
    Setting(R.string.share, Icons.Default.Share),
    Setting(R.string.account, Icons.Default.AccountBox),
    Setting(R.string.drive, Icons.Default.DirectionsCarFilled),
    Setting(R.string.flight, Icons.Default.Flight),
    Setting(R.string.privacy, Icons.Default.Security),
    Setting(R.string.support, Icons.Default.Chat),
    Setting(R.string.about, Icons.Default.Info),
    Setting(R.string.logout, Icons.Default.ExitToApp)
)
