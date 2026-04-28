package com.example.a210674_nelson_sana_lab1.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.a210674_nelson_sana_lab1.ui.theme.UiState

@Composable
fun Login_Screen(
    myViewModel: MyViewModel,
    uiState: UiState,
    buttonClick: () -> Unit,
    modifier: Modifier = Modifier,
){
    var value by remember { mutableStateOf("") }
    var password by remember { mutableStateOf(  "" ) }
    var showPassword by remember { mutableStateOf( false )}
    var output by remember { mutableStateOf( "" ) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Welcome Back",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,

        )

        Text(
            text = "Login to your account",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.outline,
            modifier = Modifier.padding(bottom = 32.dp)

            )

        OutlinedTextField(
            value = value,
            onValueChange = {
                value = it
                myViewModel.setName(value)
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            label = { Text(text = "Username") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            },
            shape = MaterialTheme.shapes.medium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                myViewModel.comparePassword(password, uiState.password)
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text( text = "Password")},
            singleLine = true,
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null
                )
            },
            trailingIcon = {
                IconButton(
                    onClick = { showPassword = !showPassword }
                ) {
                    Icon(
                        imageVector = if(showPassword) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = null
                    )
                }
            },
            shape = MaterialTheme.shapes.medium
        )

        if(output.isNotEmpty()) {
            Text(
                text = output,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(top = 8.dp, start = 4.dp)
                    .align(Alignment.Start)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick =
                if(uiState.authorise)
                    buttonClick
                else{
                    {
                        output = "Incorrect Username or Password! Please try again."
                    }
                },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = MaterialTheme.shapes.medium
        ){
            Text(
                text = "Submit",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
