package com.example.twoviewscompose.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen(navController: NavController, number1: Int, number2: Int, function: () -> Unit) {
    val bundle = requireNotNull(navController.previousBackStackEntry?.arguments)
    val number1 = bundle.getInt("number1")
    val number2 = bundle.getInt("number2")

    // Имитация задержки загрузки данных
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate("resultScreen/$number1/$number2")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Loading...")
    }
}