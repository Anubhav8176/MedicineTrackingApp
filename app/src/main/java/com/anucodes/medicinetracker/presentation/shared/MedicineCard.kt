package com.anucodes.medicinetracker.presentation.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocalPharmacy
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anucodes.medicinetracker.ui.theme.AppColors


@Composable
fun MedicineCard(){

    //Add the radio button option for the medicines list fetch from the database.
    //Also add the Taken, Due etc.; tag to all the medicines
    //Also the text decoration when done marked.

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
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = AppColors.SurfaceVariant)
                    .padding(10.dp),
                imageVector = Icons.Outlined.LocalPharmacy,
                contentDescription = "Medicine Icon"
            )
            Spacer(Modifier.width(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Metformin",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    fontSize = 13.sp,
                    text = "500 mg . Diabetes"
                )
                Text(
                    fontSize = 13.sp,
                    text = "8:00 AM"
                )
            }
        }

    }
}