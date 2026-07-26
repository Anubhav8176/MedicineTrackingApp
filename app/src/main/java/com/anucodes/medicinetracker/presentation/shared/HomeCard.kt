package com.anucodes.medicinetracker.presentation.shared

import android.R.attr.thickness
import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anucodes.medicinetracker.ui.theme.AppColors
import com.anucodes.medicinetracker.viewmodels.MedicineViewmodel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import androidx.compose.ui.platform.LocalLocale
import com.anucodes.medicinetracker.presentation.utilities.getMedSize
import com.anucodes.medicinetracker.presentation.utilities.getTakenMedSize


@SuppressLint("NonObservableLocale")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeCard(
    medicineViewmodel: MedicineViewmodel
) {

    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("EEEE, MMM d", LocalLocale.current.platformLocale)
    val formattedDate = currentDate.format(formatter)

    val medicines by medicineViewmodel.medicines.collectAsState()

    val takenMedSize = getTakenMedSize(medicines)
    val medSize = getMedSize(medicines)

    val takenFraction = remember(takenMedSize, medSize) {
        if (medSize == 0) 0f else takenMedSize.toFloat() / medSize.toFloat()
    }
    val takenPercent = remember(takenFraction) {
        (takenFraction * 100).toInt()
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        AppColors.OnPrimaryContainer,
                        AppColors.Primary,
                        AppColors.PrimaryVariant
                    )
                )
            )
            .padding(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
            contentColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .background(Color.Transparent)
        ) {
            Text(
                text = formattedDate,
                color = AppColors.TextDisabled
            )
            Spacer(Modifier.weight(1f))
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "Notification",
                tint = AppColors.TextDisabled
            )
        }
        Spacer(Modifier.height(10.dp))
        Text(
            text = "$takenMedSize of $medSize",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = "doses taken",
            fontSize = 19.sp
        )
        Spacer(Modifier.height(8.dp))
        LinearProgressIndicator(
            progress = { takenFraction },
            color = AppColors.ProgressBar,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "$takenPercent% adherence today",
            color = AppColors.TextDisabled
        )
    }
}