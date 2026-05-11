package com.anucodes.medicinetrackingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.anucodes.medicinetrackingapp.core.authentication.viewmodel.AuthViewModel
import com.anucodes.medicinetrackingapp.navigation.MainNavigationGraph
import com.anucodes.medicinetrackingapp.ui.theme.MedicineTrackingAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val authViewModel by viewModels<AuthViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            val startDestination = "auth_graph"

            MedicineTrackingAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainNavigationGraph(
                        innerPadding = innerPadding,
                        navController = navController,
                        startDestination = startDestination,
                        authViewModel = authViewModel
                    )
                }
            }
        }
    }
}
