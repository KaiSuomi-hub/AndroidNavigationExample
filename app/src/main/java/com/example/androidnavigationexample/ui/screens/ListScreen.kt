package com.example.androidnavigationexample.ui.screens

import androidx.compose.runtime.*
import androidx.compose.material.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun ListScreen(navController: NavController, inputText: String, selectedFruit: String) {
    var currentSelection by remember { mutableStateOf(selectedFruit) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text =" List Screen")
        Spacer(modifier = Modifier.height(8.dp))
        Divider()
        Text("Text received: $inputText")
        RadioButtonGroup(currentSelection) { fruit ->
            currentSelection = fruit
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            navController.navigate("selection/$inputText/$currentSelection")
        }) {
            Text("Select Fruit")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("Go Back to Previous Screen")
        }
    }
}

@Composable
fun RadioButtonGroup(selectedFruit: String, onSelectionChange: (String) -> Unit) {
    val fruits = listOf("banana", "orange", "pear")
    Column {
        fruits.forEach { fruit ->
            Row(Modifier.padding(8.dp)) {
                RadioButton(
                    selected = fruit == selectedFruit,
                    onClick = { onSelectionChange(fruit) }
                )
                Text(fruit, Modifier.padding(start = 8.dp))
            }
        }
    }
}