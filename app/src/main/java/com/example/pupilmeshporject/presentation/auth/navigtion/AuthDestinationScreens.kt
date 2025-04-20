package com.example.pupilmeshporject.presentation.auth.navigtion

sealed class AuthDestinationScreens ( val route : String) {
    object SignInScreen : AuthDestinationScreens("signIn")
    object SignUpScreen : AuthDestinationScreens("signUp")
}