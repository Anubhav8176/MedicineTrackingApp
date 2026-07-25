package com.anucodes.medicinetracker.presentation.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemGesturesPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.anucodes.medicinetracker.room.MedicineEntity
import com.anucodes.medicinetracker.ui.theme.AppColors
import com.anucodes.medicinetracker.viewmodels.MedicineViewmodel
import com.anucodes.medicinetracker.viewmodels.toMinutesOfDay


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMedicine(
    modifier: Modifier = Modifier,
    medicineViewmodel: MedicineViewmodel,
    onDismissRequest: ()-> Unit
){
    val scope = rememberCoroutineScope()

    //UI states
    var medicationName by remember { mutableStateOf("") }
    var dose by remember { mutableStateOf("") }
    var instructions by remember { mutableStateOf("") }
    var selectedHour by remember { mutableStateOf<Int?>(null) }
    var selectedMinute by remember { mutableStateOf<Int?>(null) }
    var category by remember { mutableStateOf("") }
    var frequencyDays by remember { mutableIntStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.75f)
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            .background(AppColors.SurfaceSheet)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 18.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Add Medication",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                IconButton(
                    onClick = onDismissRequest
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close Add meds"
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 3.dp),
                    text = "Medication name",
                    color = AppColors.TextSecondary
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = medicationName,
                    onValueChange = {
                        medicationName = it
                    },
                    shape = RoundedCornerShape(20.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = AppColors.SurfaceVariant,
                        unfocusedContainerColor = AppColors.SurfaceVariant,
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent
                    ),
                    placeholder = {
                        Text(
                            text = "eg.Metaformin"
                        )
                    }
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 3.dp),
                    text = "Dose",
                    color = AppColors.TextSecondary
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = dose,
                    onValueChange = {
                        dose = it
                    },
                    shape = RoundedCornerShape(20.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = AppColors.SurfaceVariant,
                        unfocusedContainerColor = AppColors.SurfaceVariant,
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent
                    ),
                    placeholder = {
                        Text(
                            text = "eg.500mg"
                        )
                    }
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 3.dp),
                    text = "Instructions",
                    color = AppColors.TextSecondary
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = instructions,
                    onValueChange = {
                        instructions = it
                    },
                    shape = RoundedCornerShape(20.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = AppColors.SurfaceVariant,
                        unfocusedContainerColor = AppColors.SurfaceVariant,
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent
                    ),
                    placeholder = {
                        Text(
                            text = "eg. Take with food"
                        )
                    }
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 3.dp),
                    text = "Categories",
                    color = AppColors.TextSecondary
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = category,
                    onValueChange = {
                        category = it
                    },
                    shape = RoundedCornerShape(20.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = AppColors.SurfaceVariant,
                        unfocusedContainerColor = AppColors.SurfaceVariant,
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent
                    ),
                    placeholder = {
                        Text(
                            text = "eg. Diabetes, BP, Protein, Gym etc."
                        )
                    }
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 3.dp),
                    text = "Days",
                    color = AppColors.TextSecondary
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = frequencyDays.toString(),
                    onValueChange = {
                        if (it.isNotEmpty() and it.isDigitsOnly()){
                            frequencyDays = it.toInt()
                        }
                    },
                    shape = RoundedCornerShape(20.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = AppColors.SurfaceVariant,
                        unfocusedContainerColor = AppColors.SurfaceVariant,
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent
                    ),
                    placeholder = {
                        Text(
                            text = "eg. 1, 2, 3 etc"
                        )
                    }
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 3.dp),
                    text = "Time",
                    color = AppColors.TextSecondary
                )
                SegmentedTimeField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onTimeChange = { h, m ->
                        selectedHour = h
                        selectedMinute = m
                    }
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 3.dp),
                    fontSize = 10.sp,
                    text = "*Enter the time in 24-hour format",
                    color = AppColors.TextSecondary
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(17.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = AppColors.Primary
                ),
                onClick = {
                    /*Add the Medication to the Room*/
                    if (
                        selectedHour != null &&
                        selectedMinute!=null &&
                        medicationName.isNotEmpty() &&
                        dose.isNotEmpty() &&
                        instructions.isNotEmpty() &&
                        frequencyDays != 0 &&
                        category.isNotEmpty()
                        ){
                        val newMedication = MedicineEntity(
                            name = medicationName,
                            dose = dose,
                            instructions = instructions,
                            isActive = true,
                            scheduledTime = toMinutesOfDay(selectedHour!!, selectedMinute!!),
                            categories = category,
                            frequencyDays = frequencyDays,
                        )

                        medicineViewmodel.addNewMedicine(newMedication)
                    }
                }
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical = 10.dp),
                    text = "Save Medication",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }
    }
}