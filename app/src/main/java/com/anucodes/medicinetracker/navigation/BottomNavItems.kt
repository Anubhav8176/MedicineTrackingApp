package com.anucodes.medicinetracker.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BarChart
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItems(
    val route: String,
    val label: String,
    val icon: ImageVector
){
    object Home: BottomNavItems(
        route = "home",
        label = "Home",
        icon = Icons.Outlined.Home
    )

    object Schedule: BottomNavItems(
        route = "schedule",
        label = "Schedule",
        icon = Icons.Outlined.CalendarMonth
    )

    object Insights: BottomNavItems(
        route = "insights",
        label = "Insights",
        icon = Icons.Outlined.BarChart
    )

    object Settings: BottomNavItems(
        route = "settings",
        label = "Settings",
        icon = Icons.Outlined.Settings
    )
}