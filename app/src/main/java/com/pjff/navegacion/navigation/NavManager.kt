package com.pjff.navegacion.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pjff.navegacion.views.DetailView
import com.pjff.navegacion.views.HomeView

@Composable
fun NavManager(){
    val navController = rememberNavController()
    //Vid 53, la ruta con la que inicia la app
    NavHost(navController = navController, startDestination = "Home"  ){
        composable("Home"){
            //La ruta home pertenece a
            HomeView(navController)
        }
        //Vid 55 Mandamos parámetros,Ma parámetros  /?{opcional}
        composable("Detail/{id}/?{opcional}", arguments = listOf(
            navArgument("id") { type = NavType.IntType },
            navArgument("opcional") { type = NavType.StringType },
        )){
            //argumento que vamos a inyectar
            val id = it.arguments?.getInt("id") ?: 0
            val opcional = it.arguments?.getString("opcional") ?: ""
            DetailView(navController, id, opcional)
        }
    }
}