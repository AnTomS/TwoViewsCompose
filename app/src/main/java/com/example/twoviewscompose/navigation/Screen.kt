package com.example.twoviewscompose.navigation

import androidx.compose.runtime.MutableState
import com.example.twoviewscompose.data.models.User

sealed class Screen(val route: String) {
    object InputScreen : Screen("input_screen")
    object LoadingScreen : Screen("loading_screen")
    object ResultScreen : Screen("result_screen")

    fun routeWithNumberArgs(number1: Int, number2: Int): String {
        return "$route/$number1/$number2"
    }

    fun routeWithSumAndListArgs(sum: MutableState<Int>, userList: MutableState<List<User>>) =
        buildString {
            append(route)
            append("/${sum.value}")
            append("/${userList.value.joinToString(",")}") // Преобразуем список пользователей в строку для передачи в URL
        }
}
