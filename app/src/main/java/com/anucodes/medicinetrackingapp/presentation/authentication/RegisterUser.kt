package com.anucodes.medicinetrackingapp.presentation.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anucodes.medicinetrackingapp.ui.theme.AppColors
import com.anucodes.medicinetrackingapp.ui.theme.MedicineTrackingAppTheme


@Composable
fun RegisterUser(
    innerPadding: PaddingValues
){
    val isDarkTheme = isSystemInDarkTheme()

    Column(
        modifier = Modifier
            .background(color = if (isDarkTheme) AppColors.backgroundDark else AppColors.background)
            .padding(innerPadding)
            .fillMaxSize(),
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Column(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }

        Spacer(modifier = Modifier.weight(0.5f))
    }
}
