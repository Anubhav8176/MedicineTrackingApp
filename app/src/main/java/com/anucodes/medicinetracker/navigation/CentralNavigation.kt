package com.anucodes.medicinetracker.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.anucodes.medicinetracker.presentation.screens.HomeScreen
import com.anucodes.medicinetracker.viewmodels.MedicineViewmodel


@Composable
fun CentralNavigation(
    medicineViewmodel: MedicineViewmodel,
    navController: NavHostController,
    innerPadding: PaddingValues
){
    Scaffold(
        bottomBar = {
            BottomNavigation(
                navController = navController
            )
        },
        floatingActionButton = {
            
        }
    ) {innerPaddings->
        NavHost(
            navController = navController,
            startDestination = BottomNavItems.Home.route
        ){
            composable(route = BottomNavItems.Home.route){
                HomeScreen(medicineViewmodel,innerPaddings)
            }

            composable(route = BottomNavItems.Schedule.route){

            }

            composable(route = BottomNavItems.Insights.route){

            }

            composable(route = BottomNavItems.Settings.route){

            }

        }
    }
}