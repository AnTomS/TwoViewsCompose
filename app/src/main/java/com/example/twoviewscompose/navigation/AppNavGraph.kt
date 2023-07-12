package com.example.twoviewscompose.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.twoviewscompose.ui.screens.InputScreen
import com.example.twoviewscompose.ui.screens.LoadingScreen
import com.example.twoviewscompose.ui.screens.ResultScreen
import com.example.twoviewscompose.viewmodel.LoadingViewModel



//файл навигации для переключения экранов
@Composable
fun Navigation() {
    //
    val navController = rememberNavController()
    val loadingViewModel = viewModel<LoadingViewModel>()
    NavHost(navController = navController, startDestination = Screen.InputScreen.route) {
        composable(route = Screen.InputScreen.route) {
            InputScreen(navController = navController)
        }

        composable(Screen.LoadingScreen.route + "/{number1}/{number2}", arguments = listOf(
            navArgument("number1") {
                type = NavType.LongType
            },
            navArgument("number2") {
                type = NavType.LongType
            }

        )) { entry ->
            LoadingScreen(
                navController = navController,
                number1 = entry.arguments?.getLong("number1") ?: 0,
                number2 = entry.arguments?.getLong("number2") ?: 0,
                loadingViewModel = loadingViewModel
            )
        }

        composable(route = Screen.ResultScreen.route) {
            ResultScreen(navController = navController, loadingViewModel = loadingViewModel)
        }
    }
}