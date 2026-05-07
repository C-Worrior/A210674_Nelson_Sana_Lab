package com.example.a210674_nelson_sana_lab1.ui

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a210674_nelson_sana_lab1.Community
import com.example.a210674_nelson_sana_lab1.R
import com.example.a210674_nelson_sana_lab1.User
import com.example.a210674_nelson_sana_lab1.ui.theme.UiState

@Composable
fun Map_Top_Bar(
    modifier: Modifier = Modifier,
    settingClick: () -> Unit,
    addCircle: () -> Unit,
    uiState: UiState
) {
    var groupClicked by remember { mutableStateOf(false) }

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(24.dp),
        color = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f),
        tonalElevation = 4.dp
    ) {
        Column(modifier = Modifier.animateContentSize()) {
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = settingClick) {
                    Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings")
                }

                Spacer(modifier = Modifier.weight(1f))

                InputChip(
                    selected = groupClicked,
                    onClick = { groupClicked = !groupClicked },
                    label = { Text(uiState.circleList.getOrNull(0)?.circleName ?: "Circle") },
                    trailingIcon = {
                        Icon(
                            imageVector = if (groupClicked) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                            contentDescription = null
                        )
                    }
                )

                Spacer(modifier = Modifier.weight(1f))

                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Mail , contentDescription = "Inbox")
                }
            }
            if (groupClicked) {
                CircleExpanded(uiState = uiState, buttonClick = addCircle)
            }
        }
    }
}

@Composable
fun CircleExpanded(uiState: UiState, buttonClick: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        uiState.circleList.forEach { circle ->
            ListItem(
                headlineContent = { Text(circle.circleName) },
                leadingContent = {
                    Image(
                        painter = painterResource(circle.photo),
                        contentDescription = null,
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                    )
                }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(onClick = buttonClick, modifier = Modifier.weight(1f)) {
                Text("Create Circle")
            }
            Button(onClick = {}, modifier = Modifier.weight(1f)) {
                Text("Join Circle")
            }
        }
    }
}

@Composable
fun Map_Bottom_Bar(sosClick: () -> Unit, checkClick: () -> Unit) {
    Surface(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        color = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f),
        tonalElevation = 4.dp
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            TextButton(onClick = checkClick) {
                Icon(Icons.Default.LocationOn, null)
                Spacer(Modifier.width(4.dp))
                Text("Check In")
            }
            FilledTonalButton(onClick = sosClick, colors = ButtonDefaults.filledTonalButtonColors(
                containerColor = MaterialTheme.colorScheme.errorContainer,
                contentColor = MaterialTheme.colorScheme.error
            )) {
                Icon(Icons.Default.Warning, null)
                Spacer(Modifier.width(4.dp))
                Text("SOS")
            }
        }
    }
}

@Composable
fun UserItem(user: User) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .fillMaxWidth(),
    ) {
        Column(modifier = Modifier.animateContentSize()) {
            ListItem(
                headlineContent = { Text(user.name, fontWeight = FontWeight.SemiBold) },
                supportingContent = { Text(text = stringResource(user.lastSeen) )},
                leadingContent = {
                    Image(
                        painter = painterResource(user.profilePic),
                        contentDescription = null,
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
            )
        }
    }
}

@Composable
fun CommunityItem(community: Community) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .fillMaxWidth(),
    ) {
        Column(modifier = Modifier.animateContentSize()) {
            ListItem(
                headlineContent = { Text(community.name, fontWeight = FontWeight.SemiBold) },
                leadingContent = {
                    Image(
                        painter = painterResource(community.image),
                        contentDescription = null,
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
            )
        }
    }
}

@Composable
fun Main_Menu(
    modifier: Modifier = Modifier,
    settingButton: () -> Unit = {},
    sosButton: () -> Unit = {},
    checkButton: () -> Unit = {},
    addCircle: () -> Unit = {},
    uiState: UiState = UiState()
) {
    var showCommunity by remember { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxSize()) {
        Box(modifier = Modifier.weight(0.5f)) {
            Image(
                painter = if (isSystemInDarkTheme()) painterResource(R.drawable.map_dark) else painterResource(R.drawable.map_light),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(modifier = Modifier.fillMaxSize()) {
                Map_Top_Bar(settingClick = settingButton, addCircle = addCircle, uiState = uiState)
                Spacer(modifier = Modifier.weight(1f))
                Map_Bottom_Bar(sosClick = sosButton, checkClick = checkButton)
            }
        }

        Surface(
            modifier = Modifier.weight(0.5f),
            tonalElevation = 2.dp,
            shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)
        ) {
            Column {
                TabRow(selectedTabIndex = if (showCommunity) 1 else 0) {
                    Tab(selected = !showCommunity, onClick = { showCommunity = false }) {
                        Text("People", modifier = Modifier.padding(16.dp))
                    }
                    Tab(selected = showCommunity, onClick = { showCommunity = true }) {
                        Text("Community", modifier = Modifier.padding(16.dp))
                    }
                }

                if (!showCommunity) {
                    LazyColumn {
                        items(uiState.userList) { user ->
                            UserItem(user)
                        }
                        item {
                            AddActionItem("Add Person", Icons.Default.PersonAdd)
                        }
                    }
                } else {
                    LazyColumn(modifier = Modifier.padding(16.dp)) {
                        items(uiState.communityList){ community ->
                            CommunityItem(community)
                        }
                        item { AddActionItem("Add Community", Icons.Default.Groups) }
                    }
                }
            }
        }
    }
}

@Composable
fun AddActionItem(label: String, icon: ImageVector) {
    OutlinedCard(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(icon, null)
            Spacer(Modifier.width(16.dp))
            Text(label, fontWeight = FontWeight.Medium)
        }
    }
}

@Preview
@Composable
fun MyView(){
    Main_Menu()
}