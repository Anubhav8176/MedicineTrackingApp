package com.anucodes.medicinetrackingapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.anucodes.medicinetrackingapp.core.authentication.viewmodel.AuthViewModel
import com.anucodes.medicinetrackingapp.presentation.authentication.LoginUser
import com.anucodes.medicinetrackingapp.presentation.authentication.RegisterUser
import com.anucodes.medicinetrackingapp.presentation.core.MainAppScreen
import com.anucodes.medicinetrackingapp.presentation.core.MedicationScreen


@Composable
fun MainNavigationGraph(
    innerPadding: PaddingValues,
    navController: NavHostController,
    startGraph: String,
    authViewModel: AuthViewModel
){
    NavHost(
        navController = navController,
        startDestination = startGraph
    ){
        navigation(
            route = "auth_graph",
            startDestination = "login_user"
        ){
            composable (
                route = "register_user"
            ){
                RegisterUser(
                    innerPadding = innerPadding,
                    navController = navController,
                    authViewModel = authViewModel
                )
            }

            composable (
                route = "login_user"
            ){
                LoginUser(
                    innerPadding = innerPadding,
                    navController = navController,
                    authViewModel = authViewModel
                )
            }
        }
        navigation(
            route = "home_graph",
            startDestination = "home_screen"
        ){

            composable(
                route = "home_screen"
            ){
                MainAppScreen()
            }

        }
    }
}