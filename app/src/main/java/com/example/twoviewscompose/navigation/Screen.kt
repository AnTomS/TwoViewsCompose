package com.example.twoviewscompose.navigation

sealed class Screen(val route: String) {
    object InputScreen : Screen("input_screen")
    object LoadingScreen : Screen("loading_screen")
    object ResultScreen : Screen("result_screen")

    fun routeWithNumberArgs(number1: Long, number2: Long): String {
        return "$route/$number1/$number2"
    }
}
