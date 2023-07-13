package com.example.twoviewscompose.navigation


//Солид класс с перечислением всех экранов для определения пути навигации
sealed class Screen(val route: String) {
    object InputScreen : Screen("input_screen")
    object LoadingScreen : Screen("loading_screen")
    object ResultScreen : Screen("result_screen")

}
