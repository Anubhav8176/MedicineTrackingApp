package com.anucodes.medicinetrackingapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.Medication
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItems(
    val route: String,
    val icon: ImageVector,
    val label: String
){
    object Medicine: BottomNavItems(
        route = "medicine",
        icon = Icons.Default.Medication,
        label = "Medicines"
    )

    object Timetable: BottomNavItems(
        route = "timetable",
        icon = Icons.Default.CalendarMonth,
        label = "Timetable"
    )

    object Inventory: BottomNavItems(
        route = "inventory",
        icon = Icons.Default.Inventory,
        label = "Inventory"
    )
}