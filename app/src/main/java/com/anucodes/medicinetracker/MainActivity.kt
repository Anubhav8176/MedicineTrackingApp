package com.anucodes.medicinetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.anucodes.medicinetracker.navigation.CentralNavigation
import com.anucodes.medicinetracker.ui.theme.MedicineTrackerTheme
import com.anucodes.medicinetracker.viewmodels.MedicineViewmodel


class MainActivity : ComponentActivity() {

    private val medicineViewmodel: MedicineViewmodel by viewModels<MedicineViewmodel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()

            MedicineTrackerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CentralNavigation(
                        medicineViewmodel = medicineViewmodel,
                        navController = navController,
                        innerPadding
                    )
                }
            }
        }
    }
}