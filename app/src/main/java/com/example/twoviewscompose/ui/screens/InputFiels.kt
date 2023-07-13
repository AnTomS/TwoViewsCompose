package com.example.twoviewscompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.twoviewscompose.navigation.Screen
import com.example.twoviewscompose.viewmodel.LoadingViewModel


@OptIn(ExperimentalMaterial3Api::class)
//создаём экран ввода чисел, в качестве параметров указываем Навконтроллер и вьюмодель
@Composable
fun InputScreen(navController: NavController, loadingViewModel: LoadingViewModel) {

    //создаём экзепляр переменной для отслеживания 1 ввёденого числа
    val number1 = loadingViewModel.number1.value

    //создаём экзепляр переменной для отслеживания 1 ввёденого числа
    val number2 = loadingViewModel.number2.value

    //создаём экзепляр переменной для показа ошибку о пустом поле ввода
    val showErrorSnackbar = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val number1 = loadingViewModel.number1.value
        val number2 = loadingViewModel.number2.value

        TextField(
            // сохраняем в переменную вводимое число и преобразовываем число в строку
            value = number1.toString(),

            // прямо указываем что мы ожидаем поулчить число и показываем пользователю только цифровую клавиатуру
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

            //с помощью функции onValueChange отображаем вводимое число и сохраняем его в переменную с помощью нашей viewmodel и метода updateNumber1(input)
            onValueChange = { input ->
                loadingViewModel.updateNumber1(input)
            },
            //описание кнопки, подсказка для пользователя
            label = { Text("Введите число 1") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            // сохраняем в переменную вводимое число и преобразовываем число в строку
            value = number2.toString(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { input ->
                loadingViewModel.updateNumber2(input)
            },
            label = { Text("Введите число 2") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        //обработка кнопки "Next Screen"
        Button(
            onClick = {
                // здесь мы встречаем перое условие, с помощью метода isValidInput() проверяем наличие пустого поля ввода
                if (loadingViewModel.isValidInput()) {
                    //если оба окна не пустые. то делаем кнопку доступной для нажатия и вызываем метод updateSum() и считаем сумму
                    loadingViewModel.updateSum()
                    //и осуществляем переход на следующий экран
                    navController.navigate(Screen.LoadingScreen.route)
                } else {
                    //если же одно из полей пустое, то вызываем метод showErrorSnackbar(). кнпока остаётся неактивной
                    loadingViewModel.showErrorSnackbar()
                }
            },
            //enabled - это параметр кнопки, который определяет, доступна ли кнопка для нажатия.
            // Если enabled установлен в true, то кнопка будет активной и пользователь сможет нажать на нее.
            // Если enabled установлен в false, то кнопка будет неактивной и пользователь не сможет нажать на нее.
            enabled = loadingViewModel.isValidInput()
        ) {
            Text("Next Screen")
        }
    }

    if (loadingViewModel.showSnackbar.value) {
        Snackbar(
            modifier = Modifier.padding(16.dp),
            action = {
                TextButton(
                    onClick = { loadingViewModel.dismissSnackbar() }
                ) {
                    Text("Dismiss")
                }
            }
        ) {
            Text("Please enter number 1 and number 2")
        }
    }
}