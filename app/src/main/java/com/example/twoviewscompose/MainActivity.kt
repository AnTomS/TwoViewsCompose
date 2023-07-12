package com.example.twoviewscompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.twoviewscompose.navigation.Navigation


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //запуск навигации для переключения между экранами
            Navigation()
        }
    }
}

