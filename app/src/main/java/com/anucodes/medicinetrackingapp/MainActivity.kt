package com.anucodes.medicinetrackingapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.anucodes.medicinetrackingapp.core.authentication.model.AuthState
import com.anucodes.medicinetrackingapp.core.authentication.viewmodel.AuthViewModel
import com.anucodes.medicinetrackingapp.navigation.MainNavigationGraph
import com.anucodes.medicinetrackingapp.presentation.authentication.SplashScreen
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
            val authState by authViewModel.authState.collectAsState()

            MedicineTrackingAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    when (authState) {
                        is AuthState.Loading -> {
                            SplashScreen()
                        }

                        is AuthState.Authenticated -> {
                            MainNavigationGraph(
                                innerPadding = innerPadding,
                                navController = navController,
                                startGraph = "home_graph",
                                authViewModel = authViewModel
                            )
                        }

                        is AuthState.Unauthenticated -> {
                            MainNavigationGraph(
                                innerPadding = innerPadding,
                                navController = navController,
                                startGraph = "auth_graph",
                                authViewModel = authViewModel
                            )
                        }
                    }
                }
            }
        }
    }
}
