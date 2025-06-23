package com.pjff.navegacion.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pjff.navegacion.components.MainButton
import com.pjff.navegacion.components.MainIconButton
import com.pjff.navegacion.components.Space
import com.pjff.navegacion.components.TitleBar
import com.pjff.navegacion.components.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailView(navController: NavController, id: Int, opcional: String?) {
    //Vid 52
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Detail view") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Green
                ),//Vid 54 icono de regreso
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) {
        ContentDetailView(navController, id, opcional)
    }
}
//Vid 53 ,solo copiamos de la pantalla anterior.
@Composable
fun ContentDetailView(navController: NavController, id: Int, opcional: String?) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Detail View")
        Space()
        //Vid 55
        TitleView(name = id.toString())
        Space()
        //Vid 56
        if (opcional == ""){
            //Para que no nos genere un espacio vacío en caso de que no venga una palabra.
            Spacer(modifier = Modifier.height(0.dp))
        }else{
            TitleView(name = opcional.orEmpty())
        }
        MainButton(name = "Return home", backColor = Color.Blue, color = Color.White) {
            //Vid 54, con pop vamos hacia atras
            navController.popBackStack()
        }
    }
}