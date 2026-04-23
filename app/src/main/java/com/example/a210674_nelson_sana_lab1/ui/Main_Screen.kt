package com.example.a210674_nelson_sana_lab1.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.a210674_nelson_sana_lab1.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main_Screen(modifier: Modifier = Modifier) {
    var selectedScreen by remember { mutableStateOf(NavigationBarItems.Map) }
    val navController: NavHostController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val showBottomBar = NavigationBarItems.entries.any{ it.name == currentRoute}
    val topBarScreen = MainScreenButton.entries.find { it.name == currentRoute }

    Scaffold(
        modifier = modifier,
        topBar = {
            if (topBarScreen != null) {
                CenterAlignedTopAppBar(
                    title = { Text(stringResource(topBarScreen.title)) },
                    navigationIcon = {
                        IconButton( onClick = { navController.navigateUp() } ){
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                )
            }
        },
        bottomBar = {
            if (showBottomBar){
                NavigationBar {
                    NavigationBarItems.entries.forEach { item ->
                        NavigationBarItem(
                            selected = selectedScreen == item,
                            onClick = {
                                navController.navigate(item.name)
                                selectedScreen = item
                            },
                            label = { Text(text = item.name) },
                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.name
                                )
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavigationBarItems.Map.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = NavigationBarItems.Map.name) {
                Live720_Combined(
                    settingButton = { navController.navigate(MainScreenButton.Setting.name)},
                    inboxButton = { navController.navigate(MainScreenButton.Inbox.name) },
                    sosButton = { navController.navigate(MainScreenButton.Sos.name) },
                    checkButton = {}
                )
            }

            composable(route = NavigationBarItems.Driving.name) {
                Driving_screen()
            }

            composable(route = MainScreenButton.Inbox.name) {
                Inbox_screen()
            }

            composable(route = MainScreenButton.Sos.name) {
                SOS_Screen()
            }

            composable(route = MainScreenButton.Setting.name){
                Setting_screen()
            }
        }
    }
}


enum class NavigationBarItems(val icon: ImageVector){
    Map(Icons.Filled.LocationOn),
    Driving(Icons.Filled.CarCrash)
}

enum class MainScreenButton(@StringRes val title: Int){
    Inbox(R.string.inbox_title),
    Sos(R.string.sos_title),
    Setting(R.string.setting_title)
}


