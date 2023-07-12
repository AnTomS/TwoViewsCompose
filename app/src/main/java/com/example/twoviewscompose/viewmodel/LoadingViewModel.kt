package com.example.twoviewscompose.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.twoviewscompose.data.models.User
import com.example.twoviewscompose.data.repository.UserRepository

class LoadingViewModel : ViewModel() {
    private val _sum = mutableStateOf(0L)
    val sum: State<Long> get() = _sum

    private val _userList = mutableStateOf(listOf<User>())
    val userList: State<List<User>> get() = _userList

    fun updateSum(number1: Long, number2: Long) {
        _sum.value = number1 + number2
    }

    fun getUsersFromRepository() {
        val users = UserRepository.getUsers()
        _userList.value = users
    }
}