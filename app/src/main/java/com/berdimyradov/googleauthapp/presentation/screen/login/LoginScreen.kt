package com.berdimyradov.googleauthapp.presentation.screen.login

import android.app.Activity
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.berdimyradov.googleauthapp.presentation.screen.common.StartActivityForResult
import com.berdimyradov.googleauthapp.presentation.screen.common.signIn

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

    val activity = LocalContext.current as Activity

    StartActivityForResult(
        key = signInState,
        onResultReceived = { tokenId ->

        },
        onDialogDismissed = {
            loginViewModel.saveSignedInState(signedIn = false)
        },
    ) { activityLauncher ->
        if (signInState) {
            signIn(
                activity = activity,
                launchActivityResult = { intentSenderRequest ->
                    activityLauncher.launch(intentSenderRequest)
                },
                accountNotFound = {
                    loginViewModel.saveSignedInState(signedIn = false)
                    loginViewModel.updateMessageBarState()
                }
            )
        }
    }
}