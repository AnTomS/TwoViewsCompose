package com.example.twoviewscompose.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.twoviewscompose.navigation.Screen
import com.example.twoviewscompose.viewmodel.LoadingViewModel
import kotlinx.coroutines.delay


////создаём экран симуляции овтета с сервера, в качестве параметров указываем Навконтроллер и вьюмодель
@Composable
fun LoadingScreen(
    navController: NavController,
    loadingViewModel: LoadingViewModel
) {

    //создаём экзепляр переменной для отслеживания 1 ввёденого числа
    val number1 = loadingViewModel.number1.value

    //создаём экзепляр переменной для отслеживания 1 ввёденого числа
    val number2 = loadingViewModel.number2.value

    //очень интересный момент, симуляция ответа от сервера, просто использу. задежрку в 2 секунды)
    LaunchedEffect(Unit) {
        delay(2000)
        //вызываю метод для подсчёта суммы чисел
        loadingViewModel.updateSum()

        //вызываю метод для получения списка пользователей из репозитория
        loadingViewModel.getUsersFromRepository()
        //навигация к экрану вывода результата
        navController.navigate(Screen.ResultScreen.route)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Вычисление суммы и загрузка списка пользователей",
            fontSize = 28.sp,
        )
    }
}