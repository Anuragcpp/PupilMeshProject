package com.example.pupilmeshporject.presentation.MainScreen.navigation

sealed class MainDestinationScreen (val route : String) {
    object MainGraph : MainDestinationScreen("mainGraph")
    object ManageScreen : MainDestinationScreen("manageScreen")
    object FaceScreen : MainDestinationScreen("faceScreen")
}