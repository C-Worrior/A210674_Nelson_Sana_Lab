package com.example.a210674_nelson_sana_lab1
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a210674_nelson_sana_lab1.ui.theme.A210674_Nelson_Sana_Lab1Theme
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            A210674_Nelson_Sana_Lab1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    Live720_Combined()
                }
            }
        }
    }

    @Composable
    fun Map_Top_Bar(modifier: Modifier = Modifier){
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painter = painterResource(R.drawable.settings_24px),
                contentDescription = "Setting",
                tint = Color.Black,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier.weight(1f))
            Box(
                modifier = Modifier
                    .border(1.dp, Color.Black)
                    .background(Color.White)
                    .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
            ){
                Text(
                    text = "Family",
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(end = 40.dp)
                )
            }

            Spacer(modifier.weight(1f))

            Icon(
                painter = painterResource(R.drawable.mail_24px),
                contentDescription = "Notification",
                tint = Color.Black,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier.width(10.dp))
            Icon(
                painter = painterResource(R.drawable.chat_24px),
                contentDescription = "Chat",
                tint = Color.Black,
                modifier = Modifier.size(32.dp)
            )
        }
    }

    @Composable
    fun Map_Bottom_Bar(modifier: Modifier = Modifier){
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
                tint = Color.Black,
                modifier = Modifier.size(32.dp)
            )
        }
    }

    @Composable
    fun Map_Bottom_Icon(icon : Painter, name : String, modifier: Modifier = Modifier) {
        Box(
            modifier = modifier.border(1.dp,Color.Black)
        ) {
            Row(
                modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Icon(
                    icon,
                    contentDescription = name,
                    tint = Color.Black,
                    modifier = Modifier.size(32.dp)
                )
                Text(
                    text = name,
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }
        }
    }

    @Composable
    fun Upper_Panel_Bar(modifier : Modifier = Modifier){
        Row (
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
        ){
            IconButton(
                onClick = { },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    painter = painterResource(R.drawable.groups_24px),
                    contentDescription = "Peoples",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(32.dp)
                )
            }

            IconButton(
                onClick = { },
                modifier = Modifier.weight(1f)
            ){
                Icon(
                    painter = painterResource(R.drawable.domain_24px),
                    contentDescription = "Places",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(32.dp)
                )
            }
        }
    }

    @Composable
    fun SearchBar(modifier: Modifier = Modifier){
        Row(
            modifier = modifier.padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            var searchInput by remember { mutableStateOf("") }
            TextField(
                value = searchInput,
                placeholder = {Text("Enter name")},
                onValueChange = {searchInput = it},
                textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
                singleLine = true,
                modifier = Modifier
                    .weight(0.8f)
            )

            Spacer(
                modifier.weight(0.01f)
            )

            Button(
                onClick = { },
                modifier = Modifier
                    .weight(0.2f)
            ){
              Icon(
                  Icons.Filled.Search,
                  contentDescription = "Search",
                  tint = Color.White,
                  modifier = Modifier.size(20.dp)
              )
            }
        }
    }

    @Composable
    fun Content(name : String, seen : String, image : Painter, modifier: Modifier = Modifier){
        Row(
            modifier = modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Image(
                image,
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Column(modifier.padding(start = 5.dp)){
                Text(
                    text = name,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Text(
                    text = seen,
                    fontSize = 12.sp,
                    color = Color.Black
                )
            }
        }
    }

    @Composable
    fun Add_Content(modifier: Modifier = Modifier){
            Row(
                modifier = modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Icon(
                    painter = painterResource(R.drawable.person_add_24px),
                    contentDescription = "Person",
                    tint = Color.Black,
                    modifier = Modifier.size(40.dp)
                )
                Text(
                    text = "Add person",
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }

    }


    @Composable
    fun Lower_Panel_Bar(modifier : Modifier = Modifier){
        Row (
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
    fun Lower_Panel_Icon(icon : Painter, name : String, modifier: Modifier = Modifier) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                icon,
                contentDescription = name,
                tint = Color.Black,
                modifier = Modifier.size(32.dp)
            )
            Text(
                text = name,
                fontSize = 14.sp,
                color = Color.Black,
            )
        }
    }

    @Composable
    fun Live720_Combined(modifier: Modifier = Modifier){
        Column(
            modifier,
        ) {
            Box(
                modifier = Modifier.weight(1f)
            ){
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
            Box(Modifier
                .background(Color.White)
                .padding(10.dp)
                .weight(1f)){
                Column(Modifier.fillMaxWidth()) {
                    Upper_Panel_Bar(Modifier.weight(0.1f))
                    SearchBar(Modifier.weight(0.15f))

                    Column(
                        modifier = Modifier
                            .weight(0.65f)
                            .fillMaxWidth()
                            .verticalScroll(rememberScrollState())
                    ){

                        Content(
                            "You",
                            "Last seen 1 minutes ago",
                            painterResource(R.drawable.avatar)
                        )

                        Content(
                            "Dad",
                            "Last seen 2 minutes ago",
                            painterResource(R.drawable.dad)
                        )

                        Content(
                            "Mom",
                            "Last seen 1 minutes ago",
                            painterResource(R.drawable.mom)
                        )

                        Content(
                            name = stringResource(R.string.user4),
                            seen = stringResource(R.string.seen4),
                            image = painterResource(R.drawable.brother)
                        )

                        Add_Content()
                    }
                    Lower_Panel_Bar(Modifier.weight(0.15f))
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        A210674_Nelson_Sana_Lab1Theme {
            Live720_Combined()
        }
    }
}
