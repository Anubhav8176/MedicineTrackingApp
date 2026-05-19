package com.anucodes.medicinetrackingapp.presentation.core

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.anucodes.medicinetrackingapp.navigation.BottomNavItems
import com.anucodes.medicinetrackingapp.presentation.shared.BottomNavBar
import com.anucodes.medicinetrackingapp.ui.theme.AppColors


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppScreen(){
    val bottomNavController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Track Medicine"
                    )
                },
                actions = {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(45.dp)
                            .border(
                                width = 2.dp,
                                color = AppColors.border,
                                shape = CircleShape
                            )
                            .padding(2.dp)
                            .clickable {

                            }
                            .clip(CircleShape),
                        contentAlignment = Alignment.Center
                    ){
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomNavBar(
                navController = bottomNavController
            )
        }
    ){innerPadding->
        NavHost(
            navController = bottomNavController,
            startDestination = BottomNavItems.Medicine.route
        ){
            composable(
                route = BottomNavItems.Medicine.route
            ){
                MedicationScreen(
                    Modifier
                        .padding(innerPadding)
                )
            }

            composable(
                route = BottomNavItems.Timetable.route
            ) {
                TimetableScreen(
                    modifier = Modifier
                        .padding(innerPadding)
                )
            }

            composable(
                route = BottomNavItems.Inventory.route
            ){
                InventoryScreen(
                    modifier = Modifier
                        .padding(innerPadding)
                )
            }
        }
    }
}