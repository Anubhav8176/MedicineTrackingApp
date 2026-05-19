package com.anucodes.medicinetrackingapp.presentation.shared

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.anucodes.medicinetrackingapp.navigation.BottomNavItems


@Composable
fun BottomNavBar(
    navController: NavController
) {
    val navItems = listOf(
        BottomNavItems.Medicine,
        BottomNavItems.Timetable,
        BottomNavItems.Inventory
    )

    NavigationBar(
        modifier = Modifier,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navItems.forEach {items ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = items.icon,
                        contentDescription = items.label
                    )
                },
                label = {
                    Text(
                        text = items.label,
                        fontSize = 16.sp
                    )
                },
                alwaysShowLabel = false,
                selected = currentRoute == items.route,
                onClick = {
                    navController.navigate(items.route){
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }

    }

}