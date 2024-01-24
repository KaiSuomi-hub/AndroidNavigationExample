package com.example.androidnavigationexample.ui.screens

import androidx.compose.runtime.*
import androidx.compose.material.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun SelectionScreen(navController: NavController, originalInputText: String, selectedFruit: String) {
    var currentSelection by remember { mutableStateOf(selectedFruit) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text =" Selection Screen")
        Spacer(modifier = Modifier.height(8.dp))
        Divider()
        RadioButtonGroup(currentSelection) { fruit ->
            currentSelection = fruit
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            navController.navigate("list/$originalInputText/$currentSelection")
        }) {
            Text("Confirm Selection")
        }
    }
}

