package com.example.pupilmeshporject.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.pupilmeshporject.presentation.MainScreen.navigation.mainGraph
import com.example.pupilmeshporject.presentation.auth.AuthViewModel
import com.example.pupilmeshporject.presentation.auth.navigtion.AuthDestinationScreens
import com.example.pupilmeshporject.presentation.auth.navigtion.authGraph

@Composable
fun RootNavGraph(navController: NavHostController,viewModel: AuthViewModel) {

    NavHost(
        navController = navController,
        startDestination = AuthDestinationScreens.AuthGraph.route
    ) {

        authGraph(navController = navController , viewModel = viewModel)

        mainGraph(navController)

    }

}