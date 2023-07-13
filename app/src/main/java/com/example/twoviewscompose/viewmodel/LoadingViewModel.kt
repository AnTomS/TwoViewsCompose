package com.example.twoviewscompose.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.twoviewscompose.data.models.User
import com.example.twoviewscompose.data.repository.UserRepository


//viewmodel для сохранения состояния и всех данных в нашем приложении
class LoadingViewModel : ViewModel() {

    //создание изменяемой переменной с помощью мутабельного состояния, на отслеживание которого подписываеися  Composable функция,
    // для отслеживания 1 ввёденого числа, в качестве дефолтного значения выбран не 0, а пустое поле
    private val _number1 = mutableStateOf("")

    //создание неизменяемой переменной для отслеживания и доступа 1 ввёденого числа
    val number1: State<String> get() = _number1


    //создание изменяемой переменной с помощью мутабельного состояния, на отслеживание которого подписываеися  Composable функция,
    // для отслеживания 2 ввёденого числа, в качестве дефолтного значения выбран не 0, а пустое поле
    private val _number2 = mutableStateOf("")

    //создание неизменяемой переменной для отслеживания и доступа к 2 ввёденого числа
    val number2: State<String> get() = _number2


    //Мутабельное состояние для хранения вычисленной суммы чисел. Сохраняется в типе данных Лонг, для вычисления больших сумм
    private val _sum = mutableStateOf(0L)

    //создание неизменяемой переменной для доступа к сумме
    val sum: State<Long> get() = _sum

    //Мутабельное состояние для хранения списка пользователей. Сохраняется в Листе
    private val _userList = mutableStateOf(listOf<User>())

    //создание неизменяемой переменной для доступа к списку пользователей
    val userList: State<List<User>> get() = _userList

    //Мутабельное состояние для хранения состояния снекбара
    private val _showSnackbar = mutableStateOf(false)

    //создание неизменяемой переменной для доступа к состоянию снекбара
    val showSnackbar: State<Boolean> get() = _showSnackbar


    //функция для отслеживания 1 ввёденого числа.

    fun updateNumber1(value: String) {
        _number1.value = value
    }

    //функция для отслеживания 2 ввёденого числа.
    fun updateNumber2(value: String) {
        _number2.value = value
    }

    //функция для вычисления суммы чисел и сохранения в переменную
    fun updateSum() {
        val number1 = _number1.value.toLongOrNull() ?: 0L
        val number2 = _number2.value.toLongOrNull() ?: 0L
        _sum.value = number1 + number2
    }

    //функция для запроса списка пользователей и сохранение его в переменную
    fun getUsersFromRepository() {
        val users = UserRepository.getUsers()
        _userList.value = users
    }

    //функция для показа снекбара
    fun showErrorSnackbar() {
        _showSnackbar.value = true
    }

    fun dismissSnackbar() {
        _showSnackbar.value = false
    }

    //функция для првоерки полей ввода. Если поля не пустые, то возвращается true, иначе false
    //если возвращает false, то пользователь не сможет нажать на кнопку
    fun isValidInput(): Boolean {
        return number1.value.isNotEmpty() && number2.value.isNotEmpty()
    }
}