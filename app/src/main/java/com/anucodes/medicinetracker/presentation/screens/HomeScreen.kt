package com.anucodes.medicinetracker.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anucodes.medicinetracker.presentation.shared.HomeCard
import com.anucodes.medicinetracker.presentation.shared.HomeList
import com.anucodes.medicinetracker.presentation.shared.MedicineCategoryChip
import com.anucodes.medicinetracker.presentation.shared.TopBar
import com.anucodes.medicinetracker.ui.theme.AppColors
import com.anucodes.medicinetracker.ui.theme.MedicineTrackerTheme
import com.anucodes.medicinetracker.viewmodels.MedicineViewmodel


@Composable
fun HomeScreen(
    medicineViewmodel: MedicineViewmodel,
    innerPadding: PaddingValues
){

    var showMenu by remember { mutableStateOf(false) }
    val allMedicines by medicineViewmodel.medicines.collectAsState()

    Scaffold(
        topBar = {
            TopBar(
                title = "MedTrack"
            ) {
                showMenu = true
            }
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {}
            ) {
                Row{
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
    ) {innerpadding->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerpadding)
                .padding(horizontal = 10.dp, vertical = 10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            HomeCard()
            Spacer(Modifier.height(10.dp))
            HomeList(allMedicines)
        }
    }
}