package com.anucodes.medicinetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.anucodes.medicinetracker.navigation.CentralNavigation
import com.anucodes.medicinetracker.room.MedicineDao
import com.anucodes.medicinetracker.room.MedicineDatabase
import com.anucodes.medicinetracker.ui.theme.MedicineTrackerTheme
import com.anucodes.medicinetracker.viewmodels.MedicineViewmodel
import com.anucodes.medicinetracker.viewmodels.MedicineViewmodelFactory


class MainActivity : ComponentActivity() {

    private val medicineViewmodel: MedicineViewmodel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return MedicineViewmodel(medicineDao = getDb().MedicineDao()) as T
            }
        }
    }

    private fun getDb(): MedicineDatabase {
        return Room.databaseBuilder(
            applicationContext,
            MedicineDatabase::class.java,
            "medicine_database"
        ).build()
    }

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