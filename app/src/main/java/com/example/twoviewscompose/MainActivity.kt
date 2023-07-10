package com.example.twoviewscompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.os.bundleOf
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.twoviewscompose.ui.screens.InputScreen
import com.example.twoviewscompose.ui.screens.LoadingScreen
import com.example.twoviewscompose.ui.screens.ResultScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "inputFragment") {
        composable("inputFragment") {
            InputScreen(navController = navController) { number1, number2 ->
                val bundle = bundleOf(
                    "number1" to number1,
                    "number2" to number2
                )
                navController.navigate("loadingFragment/$bundle")
            }
        }
        composable("loadingFragment/{number1}/{number2}") { backStackEntry ->
            val number1 = backStackEntry.arguments?.getInt("number1") ?: 0
            val number2 = backStackEntry.arguments?.getInt("number2") ?: 0
            LoadingScreen(
                navController = navController,
                number1 = number1,
                number2 = number2
            ) {
                navController.navigate("resultFragment")
            }
        }
        composable("resultFragment") {
            ResultScreen(navController = navController)
        }
    }
}