package com.example.twoviewscompose.data.repository

import com.example.twoviewscompose.data.models.User

//Репозиторий со списком пользователей
object UserRepository {
    fun getUsers(): List<User> {
        return listOf(
            User("Misha", 20),
            User("Dmitry", 21),
            User("Elena", 18),
            User("Pavel", 25)
        )
    }
}