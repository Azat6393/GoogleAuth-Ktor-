package com.berdimyradov.googleauthapp.presentation.screen.login

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val signInState by loginViewModel.signInState
    val messageBarState by loginViewModel.messageBarState

    Scaffold(
        topBar = { LoginTopBar() },
        content = {
            LoginContent(
                signedInState = signInState,
                messageBarState = messageBarState,
                onButtonClicked = {
                    loginViewModel.saveSignedInState(signedIn = true)
                }
            )
        }
    )
}