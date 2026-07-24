package com.anucodes.medicinetracker.presentation.screens

import android.view.RoundedCorner
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.anucodes.medicinetracker.presentation.shared.AddMedicine
import com.anucodes.medicinetracker.presentation.shared.HomeCard
import com.anucodes.medicinetracker.presentation.shared.MedicineCard
import com.anucodes.medicinetracker.presentation.shared.MedicineCategoryChip
import com.anucodes.medicinetracker.presentation.shared.TopBar
import com.anucodes.medicinetracker.viewmodels.MedicineViewmodel


@Composable
fun HomeScreen(
    medicineViewmodel: MedicineViewmodel,
    innerPadding: PaddingValues,
    showBottomSheet: Boolean,
    onDismissRequest: ()-> Unit
){
    val allMedicines by medicineViewmodel.medicines.collectAsState()

    Box(
        modifier = Modifier
            .padding(innerPadding)
        .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 10.dp)
        ) {
            item {
                HomeCard()
                Spacer(Modifier.height(10.dp))
            }

            item {
                FlowRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    MedicineCategoryChip(
                        title = "Home",
                        selected = true
                    )

                    MedicineCategoryChip(
                        title = "Remaining",
                        selected = false
                    )

                    MedicineCategoryChip(
                        title = "Taken",
                        selected = false
                    )
                }
                Spacer(Modifier.height(10.dp))
            }
            items(allMedicines){medicine->
                MedicineCard(medicine)
            }
        }
        if(showBottomSheet){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f))
                    .pointerInput(Unit){
                        detectTapGestures { onDismissRequest() }
                    }
            )
            AddMedicine(
                medicineViewmodel = medicineViewmodel,
                onDismissRequest = {
                    onDismissRequest()
                }
            )
        }
    }
}