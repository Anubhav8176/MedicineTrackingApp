package com.anucodes.medicinetrackingapp.presentation.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.anucodes.medicinetrackingapp.ui.theme.AppColors

@Composable
fun LoginUser(
    innerPadding: PaddingValues
){
    val isDarkTheme = isSystemInDarkTheme()

    var email by remember { mutableStateOf("") }
    var password by remember {mutableStateOf("")}
    var passwordVisibility by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .background(color = if (isDarkTheme) AppColors.backgroundDark else AppColors.background)
            .padding(innerPadding)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Column(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .border(width = 1.dp, color = Color.Blue),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = email,
                onValueChange = {
                    email = it
                },
                shape = RoundedCornerShape(15.dp)
            )
        }

        Spacer(modifier = Modifier.weight(0.5f))
    }
}