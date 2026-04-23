package com.example.a210674_nelson_sana_lab1.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CompassCalibration
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.SafetyCheck
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a210674_nelson_sana_lab1.R
import com.example.a210674_nelson_sana_lab1.User
import com.example.a210674_nelson_sana_lab1.ui.theme.AppTheme
import com.example.a210674_nelson_sana_lab1.users

@Composable
fun Map_Top_Bar(modifier: Modifier = Modifier, inboxClick: () -> Unit, settingClick: () -> Unit) {
    var groupClicked by remember {mutableStateOf(false)}
    val color by animateColorAsState(
        targetValue = if (groupClicked) MaterialTheme.colorScheme.background else Color.Transparent
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .background(color)
            .animateContentSize()
    ) {
        if (groupClicked) modifier.background(MaterialTheme.colorScheme.background)
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (!groupClicked) {
                IconButton(
                    onClick = settingClick
                ){
                    Icon(
                        painter = painterResource(R.drawable.settings_24px),
                        contentDescription = "Setting",
                        tint = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
            Spacer(modifier.weight(1f))
            Button(
                onClick = { groupClicked = !groupClicked },
                modifier = Modifier
            ) {
                Text(
                    text = "Family"
                )
                Icon(
                    imageVector = if(groupClicked) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    tint = MaterialTheme.colorScheme.onSurface,
                    contentDescription = null
                )
            }
            Spacer(modifier.weight(1f))
            if (!groupClicked) {
                Icon(
                    painter = painterResource(R.drawable.mail_24px),
                    contentDescription = "Notification",
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.size(32.dp)
                )
                Spacer(modifier.width(10.dp))
                IconButton(onClick = inboxClick){
                    Icon(
                        painter = painterResource(R.drawable.chat_24px),
                        contentDescription = "Chat",
                        tint = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
        }
        if (groupClicked) {
            CircleExpanded(color,modifier)
        }
    }
}

@Composable
fun CircleExpanded(color: Color, modifier: Modifier = Modifier){
    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(modifier = Modifier.fillMaxWidth().background(color)) {
            item {
                Row(
                ) {
                    Image(
                        painter = painterResource(R.drawable.avatar),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp),
                    )
                    Text(
                        text = "Family",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }
        Divider(modifier.fillMaxWidth())
        Spacer(modifier.height(10.dp))
        Row(
            modifier.background(color).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly

        ){
            Button(onClick = {} ) {
                Text(
                    text = "Create a circle"
                )
            }
            Button(onClick = {} ){
                Text(
                    text = "Join a circle"
                )
            }
        }
    }
}

@Composable
fun Map_Bottom_Bar(modifier: Modifier = Modifier, sosClick : () -> Unit, checkClick : () -> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
    ) {
        Map_Bottom_Icon(
            name = "Check-In",
            icon = Icons.Filled.SafetyCheck,
            onClick = checkClick
        )
        Spacer(modifier.width(10.dp))
        Map_Bottom_Icon(
            name = "SOS",
            icon = Icons.Filled.Warning,
            onClick = sosClick
        )
        Spacer(modifier.weight(1f))
        IconButton(
            onClick = {}
        ){
            Icon(
                imageVector = Icons.Filled.CompassCalibration,
                contentDescription = "Recenter"
            )
        }
    }
}

@Composable
fun Map_Bottom_Icon(modifier: Modifier = Modifier, name: String = "Test", icon: ImageVector = Icons.Filled.KeyboardArrowDown, onClick: () -> Unit = {}) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        IconButton(
            onClick = onClick
        ){
            Icon(
                icon,
                contentDescription = name
            )
        }
        Text(
            text = name,
            fontSize = 10.sp
        )
    }
}

@Composable
fun Upper_Panel_Bar(modifier: Modifier = Modifier, click : Boolean = false, onClick1 : () -> Unit, onClick2 : () -> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        IconButton(
            onClick = onClick1,
        ) {
            Icon(
                painter = painterResource(R.drawable.person_24px),
                contentDescription = "Person",
                tint = if (!click) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
            )
        }
        IconButton(
            onClick = onClick2
        ) {
            Icon(
                painter = painterResource(R.drawable.domain_24px),
                contentDescription = "Person",
                tint = if (click) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.padding(5.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        var searchInput by remember { mutableStateOf("") }
        TextField(
            value = searchInput,
            placeholder = { Text("Enter name") },
            onValueChange = { searchInput = it },
            singleLine = true,
            modifier = modifier
                .fillMaxWidth()
        )
    }
}

@Composable
fun Content(user: User, modifier: Modifier = Modifier) {
    var expand by remember { mutableStateOf(false) }
    Card(modifier = modifier
        .padding(10.dp)
        .fillMaxWidth()
        .animateContentSize()
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(user.profilePic),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp),
                )
                Text(
                    text = stringResource(user.name),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(10.dp)
                )
                Spacer(modifier.weight(1f))
                IconButton(onClick = { expand = !expand }) {
                    Icon(
                        imageVector = if (!expand) Icons.Filled.KeyboardArrowDown else Icons.Filled.KeyboardArrowUp,
                        contentDescription = "Expand"
                    )
                }
            }
            if (expand) {
                Text(
                    text = stringResource(user.lastSeen),
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun Add_Content(modifier: Modifier = Modifier) {
    Card(modifier = modifier
        .padding(10.dp)
        .fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(R.drawable.person_add_24px),
                contentDescription = "Person",
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.size(40.dp)
            )
            Text(
                text = "Add person",
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 5.dp)
            )
        }
    }

}

@Composable
fun Add_Community(modifier: Modifier = Modifier) {
    Card(modifier = modifier
        .padding(10.dp)
        .fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(R.drawable.domain_24px),
                contentDescription = "Person",
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.size(40.dp)
            )
            Text(
                text = "Add community",
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 5.dp)
            )
        }
    }

}


@Composable
fun Lower_Panel_Bar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Lower_Panel_Icon(
            painterResource(R.drawable.location_on_24px),
            "Location"
        )
        Lower_Panel_Icon(
            painterResource(R.drawable.directions_car_24px),
            "Driving"
        )
        Lower_Panel_Icon(
            painterResource(R.drawable.shield_24px),
            "Safety"
        )
    }
}

@Composable
fun Lower_Panel_Icon(icon: Painter, name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            icon,
            contentDescription = name,
            tint = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.size(32.dp)
        )
        Text(
            text = name,
            fontSize = 14.sp,
        )
    }
}

@Composable
fun Live720_Combined(settingButton: () -> Unit,inboxButton: () -> Unit, sosButton: () -> Unit, checkButton: () -> Unit, modifier: Modifier = Modifier) {
    var click by remember {mutableStateOf(false)}
    Column(
        modifier,
    ) {
        Box(
            modifier = Modifier.weight(0.45f)
        ) {
            Image(
                painter = painterResource(R.drawable.map),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            )
            Column(
                Modifier
                    .fillMaxWidth()
            ) {
                Map_Top_Bar(settingClick = settingButton, inboxClick = inboxButton)
                Spacer(Modifier.weight(1f))
                Map_Bottom_Bar(
                    modifier = Modifier.padding(bottom = 10.dp),
                    sosClick = sosButton,
                    checkClick = checkButton
                )
            }
        }
        Box(
            modifier = Modifier
                .padding(10.dp)
                .weight(0.45f)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().animateContentSize()
            ) {
                Upper_Panel_Bar(click = click, onClick1 = {click = false}, onClick2 = {click = true})
                if (!click) {
                    SearchBar(modifier = Modifier.weight(0.15f))
                    LazyColumn(modifier = Modifier
                        .weight(0.7f)
                        .animateContentSize()) {
                        items(users) { user ->
                            Content(user)
                        }
                        item{
                            Add_Content()
                        }
                    }
                }
                else{
                    Column(modifier = Modifier.weight(0.7f)) {
                        Add_Community()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LightTheme() {
    AppTheme(darkTheme = false, dynamicColor = false) {
        Live720_Combined({}, {}, {}, {})
    }
}

@Preview(showBackground = true)
@Composable
fun ExpandView() {
    CircleExpanded(MaterialTheme.colorScheme.background)
}

