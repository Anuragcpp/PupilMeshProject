package com.example.pupilmeshporject.presentation.MainScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pupilmeshporject.presentation.MainScreen.MangaPage.ManagaScreen
import com.example.pupilmeshporject.presentation.MainScreen.componentes.BottomNavItem
import com.example.pupilmeshporject.presentation.MainScreen.navigation.MainDestinationScreen

@Composable
fun MainScreen(

) {

    val navigationItems = listOf(
        BottomNavItem.BottomManga,
        BottomNavItem.BottomFace
    )
    var bottomNavCurrentIndex by remember { mutableStateOf(0) }
    val navController = rememberNavController()

    Scaffold (
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navigationItems.forEachIndexed {
                                               index, item ->
                    NavigationBarItem(
                        selected = index == bottomNavCurrentIndex,
                        onClick = {
                            bottomNavCurrentIndex = index
                            navController.navigate(item.route)
                        },
                        icon = {
                            Icon(imageVector = item.icon, contentDescription = item.title)
                        },
                        label = {
                            Text(text = item.title)
                        }
                    )

                }
            }
        }
    ) {
        innderPadding ->

        NavHost(navController = navController, startDestination = MainDestinationScreen.ManageScreen.route) {
            composable(MainDestinationScreen.FaceScreen.route){
                FaceScreen()
            }
            composable(MainDestinationScreen.ManageScreen.route){
                ManagaScreen()
            }
        }



    }
}