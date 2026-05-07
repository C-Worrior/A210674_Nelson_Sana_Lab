package com.example.a210674_nelson_sana_lab1.ui

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a210674_nelson_sana_lab1.ui.theme.UiState

@Composable
fun AddCircle_Screen(
    modifier: Modifier = Modifier,
    uiState: UiState
){
    var circleName by remember { mutableStateOf("") }

    Column(
        modifier
    ) {
        TextField(
            value = circleName,
            onValueChange = { circleName = it },
            placeholder = { Text(text = "Name Your Circle")},
            modifier = Modifier.fillMaxWidth()
        )
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.extraSmall,

        ) {
            Text(
                text = "SUGGESTIONS",
                modifier = Modifier.padding(10.dp),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        LazyColumn(
            modifier = Modifier.padding(10.dp)
        ) {
            items(uiState.suggestionList){ suggestion ->
                CircleItem(suggestion.name)
            }
        }
    }
}

@Composable
fun CircleItem(
    circleName: String,
    modifier: Modifier = Modifier
){
    Row(
        modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = null,
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.surfaceDim,
                    shape = MaterialTheme.shapes.extraLarge
                )
                .padding(10.dp)
        )
        Text(
            text = circleName,
            modifier = Modifier.padding(start = 10.dp),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun View(){
    CircleItem("Family")
}