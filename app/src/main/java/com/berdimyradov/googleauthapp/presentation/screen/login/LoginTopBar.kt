package com.berdimyradov.googleauthapp.presentation.screen.login

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.berdimyradov.googleauthapp.ui.theme.topAppbarBackgroundColor
import com.berdimyradov.googleauthapp.ui.theme.topBarContentColor

@Composable
fun LoginTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Sign In",
                color = MaterialTheme.colors.topBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppbarBackgroundColor
    )
}

@Preview
@Composable
fun LoginTopBarPreview() {
    LoginTopBar()
}