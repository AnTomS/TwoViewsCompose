package com.example.twoviewscompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.twoviewscompose.navigation.Screen
import com.example.twoviewscompose.viewmodel.LoadingViewModel


//создаём экран для отображения суммы и списка пользователей, в качестве параметров указываем Навконтроллер и вьюмодель
@Composable
fun ResultScreen(navController: NavController, loadingViewModel: LoadingViewModel) {

    //создаём экзепляр переменной для отслеживания суммы и передаём ему данные из viewModel
    val sum = loadingViewModel.sum.value

    //создаём экзепляр переменной для отслеживания списка пользователей
    val users = loadingViewModel.userList.value

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // кнопка назад. Происходит переход на экран ввода чисел с очищением стэка
        Button(
            onClick = { navController.popBackStack(Screen.InputScreen.route, inclusive = false) },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.White
            ),
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Start)

        ) {
            Text(
                text = "Назад",
                style = TextStyle(
                    color = Color.Blue,
                )
            )
        }

        // Окно для отображения суммы
        Box(
            modifier = Modifier
                .padding(16.dp)
                .heightIn(min = 0.dp, max = 140.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "$sum",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Таблица для списка объектов
        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            items(users) { user ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = user.name,
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp, end = 16.dp),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = user.age.toString(),
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 16.dp, end = 8.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}


//аннотация Превью помогает увидеть как расположены объекты, их цвет и все настройки на экране, не запуская всё полностью приложение
@Composable
@Preview(name = "test")
fun ResultScreenPreview() {
    val navController = rememberNavController()
    val loadingViewModel = LoadingViewModel()
    ResultScreen(navController = navController, loadingViewModel = loadingViewModel)
}



