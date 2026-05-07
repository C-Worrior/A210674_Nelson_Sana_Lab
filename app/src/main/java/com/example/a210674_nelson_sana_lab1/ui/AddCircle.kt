package com.example.a210674_nelson_sana_lab1.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a210674_nelson_sana_lab1.ui.theme.UiState

@Composable
fun AddCircle_Screen(
    modifier: Modifier = Modifier,
    selectionClick: (String) -> Unit,
    uiState: UiState
){
    var circleName by remember { mutableStateOf("") }
    val filteredList = remember(circleName, uiState.suggestionList){
        uiState.suggestionList.filter { it.name.contains(circleName, ignoreCase = true) }
    }
    val showUserInputCircle = circleName.isNotBlank() &&
            !filteredList.any{ it.name.equals(circleName, ignoreCase = true) }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        // Modern, clean TextField without heavy background
        TextField(
            value = circleName,
            onValueChange = { circleName = it },
            placeholder = {
                Text(
                    text = "Name Your Circle",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.outlineVariant
            ),
            textStyle = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Medium)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RectangleShape, // Flat look for organization
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
            ),
            onClick = {}
        ) {
            Text(
                text = "SUGGESTIONS",
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(filteredList){ suggestion ->
                CircleItem(
                    circleName = suggestion.name,
                    modifier = Modifier.padding(vertical = 4.dp),
                    onClick = { selectionClick(suggestion.name) }
                )
            }
            if(showUserInputCircle) {
                item {
                    CircleItem(
                        circleName,
                        onClick = { selectionClick(circleName) }
                    )
                }
            }
        }
    }
}

@Composable
fun CircleItem(
    circleName: String,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .clickable{ onClick() },
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = null,
            modifier = Modifier
                .size(36.dp) // Consistent size
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = CircleShape // Modern round border
                )
                .padding(8.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        Text(
            text = circleName,
            modifier = Modifier.padding(start = 16.dp),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun View(){
    CircleItem("Family")
}
