package com.anucodes.medicinetracker.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun BottomNavigation(
    navController: NavController
){
    val navItems = listOf(
        BottomNavItems.Home,
        BottomNavItems.Schedule,
        BottomNavItems.Insights,
        BottomNavItems.Settings
    )

    NavigationBar{
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navItems.forEach {item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label
                    )
                },
                label = {
                    Text(
                        text = item.label
                    )
                },
                alwaysShowLabel = true,
                selected = currentRoute==item.route,
                onClick = {

                }
            )
        }
    }
}