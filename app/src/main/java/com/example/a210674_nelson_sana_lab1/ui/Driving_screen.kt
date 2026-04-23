package com.example.a210674_nelson_sana_lab1.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CarCrash
import androidx.compose.material.icons.filled.ElectricBolt
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Driving_screen(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.padding(start = 10.dp, end = 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Button(
                shape = shapes.large,
                onClick = { }
            ) {
                Text(
                    text = "This Week"
                )
            }

            Button(
                shape = shapes.large,
                onClick = { }
            ) {
                Text(
                    text = "Last Week"
                )
            }
        }
        Text(
            text = "Weekly Driving Report",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Row(
            modifier = Modifier
        ) {
            Card(
                modifier = Modifier
                    .padding(20.dp)
                    .weight(1f),
                shape = MaterialTheme.shapes.medium
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Speed,
                        contentDescription = "Over speed"
                    )
                    Text(
                        text = "0"
                    )
                }
            }

            Card(
                modifier = Modifier
                    .padding(20.dp)
                    .weight(1f),
                shape = MaterialTheme.shapes.medium
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Icon(
                        imageVector = Icons.Filled.PhoneAndroid,
                        contentDescription = "Distracted"
                    )
                    Text(
                        text = "0"
                    )
                }
            }

            Card(
                modifier = Modifier
                    .padding(20.dp)
                    .weight(1f),
                shape = MaterialTheme.shapes.medium
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.CarCrash,
                        contentDescription = "Over speed"
                    )
                    Text(
                        text = "0"
                    )
                }
            }

            Card(
                modifier = Modifier
                    .padding(20.dp)
                    .weight(1f),
                shape = MaterialTheme.shapes.medium
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.ElectricBolt,
                        contentDescription = "Over speed"
                    )
                    Text(
                        text = "0"
                    )
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Card(
                modifier = Modifier.weight(1f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth() // Add this to fill card width
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Text(
                        text = "Top Speed",
                        textAlign = TextAlign.Center // Add this for text alignment
                    )
                    Text(
                        text = "--",
                        textAlign = TextAlign.Center
                    )
                }
            }

            Card(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier
                    ) {
                        Text(
                            text = "Drive"
                        )
                        Text(
                            text = "Total KM"
                        )
                    }

                    Column(
                        modifier = Modifier,
                        horizontalAlignment = Alignment.End // Align items to the right
                    ) {
                        Text(
                            text = "0"
                        )
                        Text(
                            text = "0"
                        )
                    }
                }
            }
        }

    }
}

@Preview
@Composable
fun DrivingPreview(){
    Driving_screen()
}
