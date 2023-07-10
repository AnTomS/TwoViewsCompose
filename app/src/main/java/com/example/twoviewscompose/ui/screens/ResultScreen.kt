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
import com.example.twoviewscompose.data.repository.UserRepository


@Composable
fun ResultScreen(navController: NavController) {
    val bundle = requireNotNull(navController.previousBackStackEntry?.arguments)
    val number1 = bundle.getInt("number1")
    val number2 = bundle.getInt("number2")

    val sum = number1 + number2
    val users = UserRepository.getUsers()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Sum: $sum")
        Spacer(modifier = Modifier.height(16.dp))
        Text("Users: $users")

        Button(
            onClick = { navController.popBackStack() }
        ) {
            Text("Go Back")
        }
    }
}