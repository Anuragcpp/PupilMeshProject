package com.example.pupilmeshporject.presentation.auth.navigtion

sealed class AuthDestinationScreens ( val route : String) {
    object AuthGraph : AuthDestinationScreens("auth_graph")
    object SignInScreen : AuthDestinationScreens("signIn")
    object SignUpScreen : AuthDestinationScreens("signUp")
}