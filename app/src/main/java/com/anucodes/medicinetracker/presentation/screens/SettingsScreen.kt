package com.anucodes.medicinetracker.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anucodes.medicinetracker.ui.theme.AppColors


@Composable
fun SettingsScreen(
    innerPadding: PaddingValues
){

    var doseReminderSwitch by remember { mutableStateOf(true) }
    var dailySummarySwitch by remember { mutableStateOf(true) }
    var refillAlertsSwitch by remember { mutableStateOf(false) }
    var caregiverModeSwitch by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(color = AppColors.Background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 15.dp)
        ) {
            Text(
                text = "NOTIFICATIONS",
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold,
                color = AppColors.Primary
            )
            
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        elevation = 3.dp,
                        shape = RoundedCornerShape(20.dp),
                        clip = false
                    )
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = AppColors.Surface)
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp, horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Dose Reminders",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 15.sp
                        )
                        Text(
                            text = "Push alerts for each dose",
                            fontSize = 12.sp
                        )
                    }

                    Switch(
                        checked = doseReminderSwitch,
                        onCheckedChange = {
                            doseReminderSwitch = it
                        },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = AppColors.SwitchThumb,
                            checkedTrackColor = AppColors.SwitchTrackOn,
                            uncheckedTrackColor = AppColors.SwitchTrackOff,
                            uncheckedThumbColor = AppColors.SwitchThumb,
                            uncheckedBorderColor = Color.Transparent
                        )
                    )
                }
                HorizontalDivider(
                    color = AppColors.OutlineVariant
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp, horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Daily Summary",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 15.sp
                        )
                        Text(
                            text = "End-of-day report at 9PM",
                            fontSize = 12.sp
                        )
                    }
                    Switch(
                        checked = dailySummarySwitch,
                        onCheckedChange = {
                            dailySummarySwitch = it
                        },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = AppColors.SwitchThumb,
                            checkedTrackColor = AppColors.SwitchTrackOn,
                            uncheckedTrackColor = AppColors.SwitchTrackOff,
                            uncheckedThumbColor = AppColors.SwitchThumb,
                            uncheckedBorderColor = Color.Transparent
                        )
                    )
                }
                HorizontalDivider(
                    color = AppColors.OutlineVariant
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp, horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Refill alerts",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 15.sp
                        )
                        Text(
                            text = "When supply drops below 10 days",
                            fontSize = 12.sp
                        )
                    }
                    Switch(
                        checked = refillAlertsSwitch,
                        onCheckedChange = {
                            refillAlertsSwitch = it
                        },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = AppColors.SwitchThumb,
                            checkedTrackColor = AppColors.SwitchTrackOn,
                            uncheckedTrackColor = AppColors.SwitchTrackOff,
                            uncheckedThumbColor = AppColors.SwitchThumb,
                            uncheckedBorderColor = Color.Transparent
                        )
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = "SHARING",
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold,
                color = AppColors.Primary
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        elevation = 3.dp,
                        shape = RoundedCornerShape(20.dp),
                        clip = false
                    )
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = AppColors.Surface)
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp, horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Caregiver mode",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 15.sp
                        )
                        Text(
                            text = "Share progress with a caregiver",
                            fontSize = 12.sp
                        )
                    }
                    Switch(
                        checked = caregiverModeSwitch,
                        onCheckedChange = {
                            caregiverModeSwitch = it
                        },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = AppColors.SwitchThumb,
                            checkedTrackColor = AppColors.SwitchTrackOn,
                            uncheckedTrackColor = AppColors.SwitchTrackOff,
                            uncheckedThumbColor = AppColors.SwitchThumb,
                            uncheckedBorderColor = Color.Transparent
                        )
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 15.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        elevation = 3.dp,
                        shape = RoundedCornerShape(20.dp),
                        clip = false
                    )
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = AppColors.Surface)
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp, horizontal = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Doctor contacts",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Open Icon"
                    )
                }
                HorizontalDivider(
                    color = AppColors.OutlineVariant
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp, horizontal = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Export health data",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Open Icon"
                    )
                }
                HorizontalDivider(
                    color = AppColors.OutlineVariant
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp, horizontal = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Privacy Policy",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Open Icon"
                    )
                }
            }
        }
    }
}