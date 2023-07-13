package com.example.twoviewscompose.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.twoviewscompose.ui.screens.InputScreen
import com.example.twoviewscompose.ui.screens.LoadingScreen
import com.example.twoviewscompose.ui.screens.ResultScreen
import com.example.twoviewscompose.viewmodel.LoadingViewModel


//файл навигации для переключения экранов
@Composable
fun Navigation() {
    //создаём экземпляр  навконтроллера с помощью rememberNavController,
    val navController = rememberNavController()

    //создаём экземпляр viewModel
    val loadingViewModel = viewModel<LoadingViewModel>()

    //создаём навигацию, указываем Навконтроллер, стартовый экран
    NavHost(navController = navController, startDestination = Screen.InputScreen.route) {

        //Определяем какие будут экраны в графе, с помощью заранее созданного sealed class Screen
        // определяем конечный маршрут навигации передаем navController и loadingViewModel в качестве параметров.

        composable(route = Screen.InputScreen.route) {
            InputScreen(navController = navController, loadingViewModel = loadingViewModel)
        }

        composable(Screen.LoadingScreen.route) {
            LoadingScreen(navController = navController, loadingViewModel = loadingViewModel)
        }

        composable(route = Screen.ResultScreen.route) {
            ResultScreen(navController = navController, loadingViewModel = loadingViewModel)
        }
    }
}