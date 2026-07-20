package com.anucodes.medicinetracker.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anucodes.medicinetracker.ui.theme.AppColors
import java.util.Locale
import java.util.Locale.getDefault


@Composable
fun SettingsScreen(
    innerPadding: PaddingValues
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(color = AppColors.Background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = "NOTIFICATIONS",
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold,
                color = AppColors.Primary
            )
        }
    }
}