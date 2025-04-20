package com.example.pupilmeshporject.presentation.MainScreen.navigation

import androidx.compose.material3.Scaffold
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.pupilmeshporject.presentation.MainScreen.FaceScreen
import com.example.pupilmeshporject.presentation.MainScreen.ManagaScreen


fun NavGraphBuilder.mainGraph(navHostController: NavHostController){

    navigation(
        startDestination = MainDestinationScreen.ManageScreen.route,
        route = MainDestinationScreen.MainGraph.route
    ){


        composable(MainDestinationScreen.ManageScreen.route){
            ManagaScreen()
        }

        composable(MainDestinationScreen.FaceScreen.route){
            FaceScreen()
        }
    }
}