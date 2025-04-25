package com.example.pupilmeshporject.presentation.MainScreen.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.pupilmeshporject.presentation.MainScreen.MainScreen


fun NavGraphBuilder.mainGraph(navHostController: NavHostController){

    navigation(
        startDestination = MainDestinationScreen.MainScreen.route,
        route = MainDestinationScreen.MainGraph.route
    ){


        composable(MainDestinationScreen.MainScreen.route){
            MainScreen()
        }
    }
}