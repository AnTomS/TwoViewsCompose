package com.example.twoviewscompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.twoviewscompose.ui.screens.InputScreen
import com.example.twoviewscompose.ui.screens.LoadingScreen


@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.InputScreen.route) {
        composable(route = Screen.InputScreen.route) {
            InputScreen(navController = navController)
        }

        composable(Screen.LoadingScreen.route + "/{number1}/{number2}", arguments = listOf(
            navArgument("number1") {
                type = NavType.IntType
            },
            navArgument("number2") {
                type = NavType.IntType
            }

        )) { entry ->
            LoadingScreen(
                navController = navController,
                number1 = entry.arguments?.getInt("number1") ?: 0,
                number2 = entry.arguments?.getInt("number2") ?: 0
            ) {
                navController.navigate(Screen.ResultScreen.route)
            }
        }
    }
}