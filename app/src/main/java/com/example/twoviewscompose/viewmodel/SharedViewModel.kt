package com.example.twoviewscompose.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val sharedData = mutableStateOf(0)

    fun updateSharedData(newValue: Int) {
        sharedData.value = newValue
    }
}