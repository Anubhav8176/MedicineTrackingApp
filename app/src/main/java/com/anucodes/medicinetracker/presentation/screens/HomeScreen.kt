package com.anucodes.medicinetracker.presentation.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.anucodes.medicinetracker.presentation.shared.AddMedicine
import com.anucodes.medicinetracker.presentation.shared.HomeCard
import com.anucodes.medicinetracker.presentation.shared.MedicineCard
import com.anucodes.medicinetracker.presentation.shared.MedicineCategoryChip
import com.anucodes.medicinetracker.viewmodels.MedicineViewmodel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    medicineViewmodel: MedicineViewmodel,
    innerPadding: PaddingValues,
    showBottomSheet: Boolean,
    onDismissRequest: ()-> Unit
){
    val allMedicines by medicineViewmodel.medicines.collectAsState()

    var selectedFilter by remember { mutableStateOf("Home") }
    var medicineList by remember { mutableStateOf(allMedicines) }

    val filterOptions = listOf(
        "Home",
        "Remaining",
        "Taken"
    )

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
                HomeCard(medicineViewmodel = medicineViewmodel)
                Spacer(Modifier.height(10.dp))
            }

            item {
                FlowRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    filterOptions.forEach {name->
                        MedicineCategoryChip(
                            title = name,
                            selected = if(name==selectedFilter)true else false,
                            onClick = {new->
                                selectedFilter = new
                            }
                        )
                    }
                }
                Spacer(Modifier.height(10.dp))
            }
            items(medicineList){medicine->
                MedicineCard(medicine, medicineViewmodel)
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