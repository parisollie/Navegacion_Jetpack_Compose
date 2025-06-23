package com.pjff.navegacion.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.pjff.navegacion.components.ActionButton
import com.pjff.navegacion.components.MainButton
import com.pjff.navegacion.components.Space
import com.pjff.navegacion.components.TitleBar
import com.pjff.navegacion.components.TitleView


//Vid 48, que nos quite los valores de padding
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController) {
    //Vid 48, nos dara una estructura para hacer un botton flotante
    Scaffold(
        //Vid 49 agregamos un top bar
        topBar = {
            //Pondremos en el centro el titulo
            CenterAlignedTopAppBar(
                //Traemos nuestro Title bar
                title = { TitleBar(name = "Home View") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Blue
                )
            )
        },
        floatingActionButton = {
            //Vid 50
            ActionButton()
        }
    ) {
        //Vid 48, Cuerpo del scaffold
        //Vid 53, agregamos el nav controller.
        ContentHomeView(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//Vid 53, agregamos el navController: NavController
fun ContentHomeView(navController: NavController) {
    //Vid 55
    val id = 123
    //Vid 56
    var opcional by remember { mutableStateOf("") }
    //Vid 48
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Vid 51, mandamos a llamar a TittleView
        TitleView(name = "Home View")
        Space()
        //vid 56
        TextField(
            value = opcional,
            onValueChange = { opcional = it },
            label = { Text(text = "Opcional") }
        )
        //Vid 51
        MainButton(name = "Detail view", backColor = Color.Red, color = Color.White) {
            //Vid 53, ponemos la ruta de navegacion,le pusimos Detail en Nav Manager
            //Vid 55 le mandamos el parámetro Detail/${id}
            navController.navigate("Detail/${id}/?${opcional}")
        }
    }
}