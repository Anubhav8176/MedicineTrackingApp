package com.anucodes.medicinetracker.presentation.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material.icons.outlined.LocalPharmacy
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anucodes.medicinetracker.room.MedicineEntity
import com.anucodes.medicinetracker.ui.theme.AppColors
import com.anucodes.medicinetracker.viewmodels.MedicineViewmodel
import com.anucodes.medicinetracker.viewmodels.fromMinutesOfDay


@Composable
fun MedicineCard(
    medicine: MedicineEntity,
    medicineViewmodel: MedicineViewmodel
){
    //Also add the Taken, Due etc.; tag to all the medicines
    var isTaken by remember { mutableStateOf(false) }
    val time by remember { mutableStateOf(fromMinutesOfDay(medicine.scheduledTime)) }

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = AppColors.Surface
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = AppColors.SurfaceVariant)
                        .padding(10.dp),
                    imageVector = Icons.Outlined.LocalPharmacy,
                    contentDescription = "Medicine Icon"
                )
                Spacer(Modifier.width(10.dp))
                Column {
                    Text(
                        text = medicine.name,
                        fontWeight = FontWeight.Bold,
                        textDecoration = if(medicine.isTaken) TextDecoration.LineThrough else TextDecoration.None
                    )
                    Text(fontSize = 13.sp, text = "${medicine.dose} . ${medicine.categories}")
                    Text(fontSize = 13.sp, text = "${time.first}: ${time.second}" )
                }
            }

            IconButton(onClick = {
                isTaken = !isTaken
                val newMedicine = medicine.copy(isTaken = isTaken)
                medicineViewmodel.updateMedicine(medicine = newMedicine)
            }) {
                Icon(
                    imageVector = if (medicine.isTaken) Icons.Outlined.CheckCircle else Icons.Outlined.Circle,
                    contentDescription = if (medicine.isTaken) "Checked circle" else "Unchecked circle",
                    tint = AppColors.Primary
                )
            }
        }
    }
}