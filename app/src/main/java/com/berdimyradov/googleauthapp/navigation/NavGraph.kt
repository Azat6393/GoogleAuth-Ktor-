package com.berdimyradov.googleauthapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.berdimyradov.googleauthapp.presentation.screen.login.LoginScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(route = Screen.Login.route){
            LoginScreen(navController)
        }
        composable(route = Screen.Profile.route){

        }
    }
}