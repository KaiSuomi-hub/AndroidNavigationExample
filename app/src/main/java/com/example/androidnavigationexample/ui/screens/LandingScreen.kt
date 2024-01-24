package com.example.androidnavigationexample.ui.screens

import androidx.compose.runtime.*
import androidx.compose.material.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.*
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LandingScreen(navController: NavController) {
    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(text ="Landing Screen")
        Spacer(modifier = Modifier.height(8.dp))
        Divider()
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter Text") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            navController.navigate("list/$text")
        }) {
            Text("Go to List")
        }
    }
}
