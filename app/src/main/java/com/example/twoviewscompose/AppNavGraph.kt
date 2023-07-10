package com.example.twoviewscompose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.twoviewscompose.ui.screens.InputScreen


@Composable
fun AppNavGraph(
    modifier: Modifier,
    navController: NavController
) {
    NavHost(navController = navController as NavHostController, startDestination = "main") {
        composable("main") {
            InputScreen(navController = navController, param = 0)
        }
    }


}