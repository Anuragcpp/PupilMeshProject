package com.example.pupilmeshporject.presentation.auth.navigtion

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.pupilmeshporject.presentation.auth.AuthViewModel
import com.example.pupilmeshporject.presentation.auth.SignInScreen
import com.example.pupilmeshporject.presentation.auth.SignUpScreen


fun NavGraphBuilder.authGraph(
    navController: NavHostController,
    viewModel: AuthViewModel
) {

    navigation(
        startDestination = AuthDestinationScreens.SignInScreen.route,
        route = AuthDestinationScreens.AuthGraph.route
    ) {

        composable(AuthDestinationScreens.SignInScreen.route){
            SignInScreen(viewModel = viewModel) {
                navController.navigate(AuthDestinationScreens.SignUpScreen.route)
            }
        }

        composable(AuthDestinationScreens.SignUpScreen.route){
            SignUpScreen(viewModel = viewModel) {
                navController.navigate(AuthDestinationScreens.SignInScreen.route)
            }
        }
    }

}