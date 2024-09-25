    package com.example.androidnavigationexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidnavigationexample.ui.screens.LandingScreen  // Remeber to import the screens
import com.example.androidnavigationexample.ui.screens.ListScreen
import com.example.androidnavigationexample.ui.screens.SelectionScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "landing") {
                composable("landing") {
                    LandingScreen(navController)
                }
                composable("list/{inputText}") { backStackEntry ->
                    ListScreen(
                        navController,
                        backStackEntry.arguments?.getString("inputText") ?: "",
                        selectedFruit = "banana"  // Default fruit
                    )
                }
                composable("list/{inputText}/{selectedFruit}") { backStackEntry ->
                    ListScreen(
                        navController,
                        backStackEntry.arguments?.getString("inputText") ?: "",
                        backStackEntry.arguments?.getString("selectedFruit") ?: "banana"
                    )
                }
                composable("selection/{inputText}/{selectedFruit}") { backStackEntry ->
                    SelectionScreen(
                        navController,
                        backStackEntry.arguments?.getString("inputText") ?: "",
                        backStackEntry.arguments?.getString("selectedFruit") ?: "banana"
                    )
                }
            }
        }
    }
}
