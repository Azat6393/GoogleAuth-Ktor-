package com.berdimyradov.googleauthapp.navigation

sealed class Screen(val route: String){
    object Login: Screen(route = "login_screen")
    object Profile: Screen("profile_screen")
}
