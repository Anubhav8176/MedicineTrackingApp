package com.anucodes.medicinetracker.presentation.shared

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.anucodes.medicinetracker.room.MedicineEntity


@Composable
fun HomeList(
    allMedicines: List<MedicineEntity>
){

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
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(allMedicines){medicine->
            MedicineCard()
        }
    }
}