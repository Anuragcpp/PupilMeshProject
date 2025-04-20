package com.example.pupilmeshporject.presentation.MainScreen.componentes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.pupilmeshporject.presentation.MainScreen.navigation.MainDestinationScreen

sealed class BottomNavItem (val route : String, val title : String, val icon : ImageVector) {
    object BottomManga : BottomNavItem(MainDestinationScreen.ManageScreen.route,"Manga",Icons.Default.MailOutline)
    object BottomFace : BottomNavItem(MainDestinationScreen.FaceScreen.route,"Face",Icons.Default.Face)
}