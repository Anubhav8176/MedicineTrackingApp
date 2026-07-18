package com.anucodes.medicinetracker.navigation

import android.util.Log
import android.view.RoundedCorner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.anucodes.medicinetracker.presentation.screens.HomeScreen
import com.anucodes.medicinetracker.presentation.screens.ScheduleScreen
import com.anucodes.medicinetracker.presentation.shared.TopBar
import com.anucodes.medicinetracker.ui.theme.AppColors
import com.anucodes.medicinetracker.viewmodels.MedicineViewmodel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CentralNavigation(
    medicineViewmodel: MedicineViewmodel,
    navController: NavHostController,
    innerPadding: PaddingValues
){
    var showMenu by remember { mutableStateOf(false) }

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()


    var showBottomSheet by remember { mutableStateOf(false) }
    var medicationName by remember { mutableStateOf("") }
    var dose by remember { mutableStateOf("") }
    var instructions by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopBar(
                title = "MedTrack"
            ) {
                showMenu = true
            }
        },
        bottomBar = {
            BottomNavigation(
                navController = navController
            )
        },
        floatingActionButton = {

            val navControllerBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navControllerBackStackEntry?.destination?.route

            if(currentRoute == BottomNavItems.Home.route && !showBottomSheet){
                ExtendedFloatingActionButton(
                    containerColor = AppColors.Primary,
                    contentColor = Color.White,
                    onClick = {
                        showBottomSheet = true
                    }
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ){
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add button"
                        )
                        Text(
                            text = "Add Med"
                        )
                    }
                }
            }
        }
    ) {innerPaddings->
        NavHost(
            navController = navController,
            startDestination = BottomNavItems.Home.route
        ){
            composable(route = BottomNavItems.Home.route){
                HomeScreen(
                    medicineViewmodel,
                    innerPaddings,
                    showBottomSheet,
                    onDismissRequest = {
                        showBottomSheet = false
                    }
                )
            }

            composable(route = BottomNavItems.Schedule.route){
                ScheduleScreen()
            }

            composable(route = BottomNavItems.Insights.route){

            }

            composable(route = BottomNavItems.Settings.route){

            }

        }
    }
}