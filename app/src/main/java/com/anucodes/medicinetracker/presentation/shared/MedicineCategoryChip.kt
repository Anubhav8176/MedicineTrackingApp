package com.anucodes.medicinetracker.presentation.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anucodes.medicinetracker.ui.theme.AppColors


@Composable
fun MedicineCategoryChip(
    title: String,
    selected: Boolean,
    onClick: (String)-> Unit
){

    Text(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .clickable(
                enabled = true,
                onClick = {onClick(title)}
            )
            .background(
                color = if (selected) AppColors.PrimaryVariant else AppColors.PrimaryContainer
            )
            .padding(vertical = 5.dp, horizontal = 10.dp),
        text = title,
        color = if (selected) Color.White else AppColors.TextSecondary,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    )

}