package com.example.a210674_nelson_sana_lab1.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Driving_Screen(modifier: Modifier = Modifier) {
    var selectedWeek by remember { mutableStateOf("this") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Week Selection
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally)
        ) {
            FilledTonalButton(
                onClick = { selectedWeek = "this" },
                shape = RoundedCornerShape(12.dp),
                colors = if (selectedWeek == "this") ButtonDefaults.filledTonalButtonColors()
                else ButtonDefaults.filledTonalButtonColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Text("This Week")
            }
            FilledTonalButton(
                onClick = { selectedWeek = "last" },
                shape = RoundedCornerShape(12.dp),
                colors = if (selectedWeek == "last") ButtonDefaults.filledTonalButtonColors()
                else ButtonDefaults.filledTonalButtonColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Text("Last Week")
            }
        }

        Text(
            text = "Weekly Driving Report",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )

        // Metrics Grid (2x2)
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                MetricCard(Icons.Default.Speed, "Speeding", "0", Modifier.weight(1f))
                MetricCard(Icons.Default.PhoneAndroid, "Distracted", "0", Modifier.weight(1f))
            }
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                MetricCard(Icons.Default.CarCrash, "Hard Brake", "0", Modifier.weight(1f))
                MetricCard(Icons.Default.ElectricBolt, "Rapid Accel", "0", Modifier.weight(1f))
            }
        }

        // Summary Cards
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ElevatedCard(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Top Speed", style = MaterialTheme.typography.labelLarge)
                    Text("--", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
                    Text("km/h", style = MaterialTheme.typography.labelSmall)
                }
            }

            ElevatedCard(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Drives", style = MaterialTheme.typography.labelMedium)
                        Text("0", fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Total Distance", style = MaterialTheme.typography.labelMedium)
                        Text("0 km", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
fun MetricCard(icon: ImageVector, label: String, value: String, modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )
            Column {
                Text(text = value, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                Text(text = label, style = MaterialTheme.typography.labelSmall)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DrivingPreview() {
    Driving_Screen()
}
