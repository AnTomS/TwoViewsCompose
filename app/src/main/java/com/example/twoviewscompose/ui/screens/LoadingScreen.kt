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

@Composable
fun LoadingScreen(
    navController: NavController,
    number1: Long,
    number2: Long,
    loadingViewModel: LoadingViewModel
) {
    LaunchedEffect(Unit) {
        delay(2000)
        loadingViewModel.updateSum(number1, number2)
        loadingViewModel.getUsersFromRepository()
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