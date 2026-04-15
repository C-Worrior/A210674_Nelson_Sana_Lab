package com.example.a210674_nelson_sana_lab1
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.IconButton
import com.example.a210674_nelson_sana_lab1.ui.theme.AppTheme
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme(dynamicColor = false) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Live720_Combined()
                }
            }
        }
    }

    @Composable
    fun Map_Top_Bar(modifier: Modifier = Modifier) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.settings_24px),
                contentDescription = "Setting",
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier.weight(1f))
            Box(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
            ) {
                Text(
                    text = "Family",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(end = 40.dp)
                )
            }

            Spacer(modifier.weight(1f))

            Icon(
                painter = painterResource(R.drawable.mail_24px),
                contentDescription = "Notification",
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier.width(10.dp))
            Icon(
                painter = painterResource(R.drawable.chat_24px),
                contentDescription = "Chat",
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.size(32.dp)
            )
        }
    }

    @Composable
    fun Map_Bottom_Bar(modifier: Modifier = Modifier) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
        ) {
            Map_Bottom_Icon(
                painterResource(R.drawable.home_pin_24px),
                "Check In",
            )
            Spacer(modifier.width(10.dp))
            Map_Bottom_Icon(
                painterResource(R.drawable.e911_emergency_24px),
                "SOS"
            )
            Spacer(modifier.weight(1f))
            Icon(
                painter = painterResource(R.drawable.explore_24px),
                contentDescription = "Explore",
                modifier = Modifier.size(32.dp)
            )
        }
    }

    @Composable
    fun Map_Bottom_Icon(icon: Painter, name: String, modifier: Modifier = Modifier) {
        Box(
            modifier = modifier
        ) {
            Row(
                modifier = Modifier.padding(start = 5.dp, end = 10.dp),
                verticalAlignment = Alignment.CenterVertically

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
        Card(modifier = modifier.padding(10.dp).fillMaxWidth()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(user.profilePic),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp),
                )
                Column(modifier.padding(start = 5.dp)) {
                    Text(
                        text = stringResource(user.name),
                        fontSize = 20.sp
                    )
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
        Card(modifier = modifier.padding(10.dp).fillMaxWidth()) {
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
        Card(modifier = modifier.padding(10.dp).fillMaxWidth()) {
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
    fun Live720_Combined(modifier: Modifier = Modifier) {
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
                        .padding(top = 30.dp)
                ) {
                    Map_Top_Bar()
                    Spacer(Modifier.weight(1f))
                    Map_Bottom_Bar(modifier = Modifier.padding(bottom = 10.dp))
                }
            }
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .weight(0.45f)
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Upper_Panel_Bar(click = click, onClick1 = {click = false}, onClick2 = {click = true})
                    if (!click) {
                        SearchBar(modifier = Modifier.weight(0.15f))
                        LazyColumn(modifier = Modifier.weight(0.7f)) {
                            items(users) { user ->
                                Content(user)
                            }
                            item(){
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
            Lower_Panel_Bar(Modifier.weight(0.1f))
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun LightTheme() {
        AppTheme(darkTheme = false, dynamicColor = false) {
            Live720_Combined()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DarkTheme() {
        AppTheme(darkTheme = true, dynamicColor = false) {
            Live720_Combined()
        }
    }
}

