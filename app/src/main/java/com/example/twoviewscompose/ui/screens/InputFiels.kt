package com.example.twoviewscompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.twoviewscompose.navigation.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputScreen(navController: NavController) {
    val number1 = remember { mutableStateOf(0) }
    val number2 = remember { mutableStateOf(0) }
    val showErrorSnackbar = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = number1.value.toString(),
            onValueChange = { number1.value = it.toIntOrNull() ?: 0 },
            label = { Text("Number 1") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = number2.value.toString(),
            onValueChange = { number2.value = it.toIntOrNull() ?: 0 },
            label = { Text("Number 2") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (number1.value != 0 && number2.value != 0) {

                    navController.navigate(
                        Screen.LoadingScreen.routeWithNumberArgs(
                            number1.value,
                            number2.value
                        )
                    )
                } else {
                    showErrorSnackbar.value = true
                }
            },
            enabled = number1.value != 0 && number2.value != 0
        ) {
            Text("Next Screen")
        }
    }

    if (showErrorSnackbar.value) {
        Snackbar(
            modifier = Modifier.padding(16.dp),
            action = {
                TextButton(
                    onClick = { showErrorSnackbar.value = false }
                ) {
                    Text("Dismiss")
                }
            }
        ) {
            Text("Please enter number 1 and number 2")
        }
    }
}