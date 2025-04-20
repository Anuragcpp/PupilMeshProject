package com.example.pupilmeshporject.presentation.auth.navigtion

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pupilmeshporject.presentation.auth.AuthViewModel
import com.example.pupilmeshporject.presentation.auth.SignInScreen
import com.example.pupilmeshporject.presentation.auth.SignUpScreen
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun AuthNavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val viewModel : AuthViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = AuthDestinationScreens.SignInScreen.route ) {

        composable(AuthDestinationScreens.SignInScreen.route) {
            SignInScreen(viewModel = viewModel){
                navController.navigate(AuthDestinationScreens.SignUpScreen.route)
            }
        }
        
        composable(AuthDestinationScreens.SignUpScreen.route){
            SignUpScreen(viewModel = viewModel){
                navController.navigate(AuthDestinationScreens.SignInScreen.route)
            }
        }

    }

}