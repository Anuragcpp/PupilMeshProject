package com.example.pupilmeshporject.presentation.MainScreen.componentes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigation(
    navHostController: NavHostController
) {
    val bottomItems = listOf(
        BottomNavItem.BottomManga,
        BottomNavItem.BottomFace
    )
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentState = navBackStackEntry?.destination?.route
    



}