package com.example.twoviewscompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.twoviewscompose.viewmodel.LoadingViewModel


@Composable
fun ResultScreen(navController: NavController,loadingViewModel: LoadingViewModel) {
    val sum = loadingViewModel.sum.value
    val users = loadingViewModel.userList.value

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = { navController.popBackStack() }
        ) {
            Text("Вернуться назад")
        }


        Text("Sum: $sum")
        Spacer(modifier = Modifier.height(16.dp))
        Text("Users: ${users.joinToString(", ")}")


    }
}