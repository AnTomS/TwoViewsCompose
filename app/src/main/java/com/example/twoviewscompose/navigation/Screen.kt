package com.example.twoviewscompose.navigation

sealed class Screen(val route: String) {
    object InputScreen : Screen("input_screen")
    object LoadingScreen : Screen("loading_screen")
    object ResultScreen : Screen("result_screen")

    fun routeWithArgs(vararg args: String) = buildString {
        append(route)
        args.forEach { arg ->
            append("/$arg")
        }
    }

}
