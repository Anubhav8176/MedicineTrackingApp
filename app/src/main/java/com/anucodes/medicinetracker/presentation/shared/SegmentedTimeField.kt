package com.anucodes.medicinetracker.presentation.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anucodes.medicinetracker.ui.theme.AppColors


enum class TimeSegment {
    HOUR,
    MINUTE
}

data class ParsedTime(
    val hour: Int?,
    val minute: Int?,
    val activeSegment: TimeSegment
)

fun parseTimeDigits(raw: String): ParsedTime {
    var hour: Int? = null
    var minute: Int? = null
    var segment = TimeSegment.HOUR

    for (ch in raw) {
        val d = ch.digitToInt()
        if (segment == TimeSegment.HOUR) {
            if (hour == null) {
                hour = d
                if (d > 2) segment = TimeSegment.MINUTE
            } else {
                hour = (hour * 10 + d).coerceIn(0, 23)
                segment = TimeSegment.MINUTE
            }
        } else {
            minute = if (minute == null) d else (minute * 10 + d).coerceIn(0, 59)
        }
    }
    return ParsedTime(hour, minute, segment)
}

@Composable
fun SegmentedTimeField(
    modifier: Modifier = Modifier,
    onTimeChange: (hour: Int?, minute: Int?) -> Unit = { _, _ -> }
) {
    var rawDigits by remember { mutableStateOf(TextFieldValue("")) }
    val focusRequester = remember { FocusRequester() }
    val interactionSource = remember { MutableInteractionSource() }

    val parsed = remember(rawDigits.text) { parseTimeDigits(rawDigits.text) }

    LaunchedEffect(parsed.hour, parsed.minute) {
        onTimeChange(parsed.hour, parsed.minute)
    }

    val hourText = parsed.hour?.let { it.toString().padStart(2, '0') } ?: "--"
    val minuteText = parsed.minute?.let { it.toString().padStart(2, '0') } ?: "--"

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(AppColors.SurfaceVariant)
            .clickable(interactionSource = interactionSource, indication = null) {
                focusRequester.requestFocus()
            }
            .padding(horizontal = 16.dp, vertical = 15.dp)
    ) {

        BasicTextField(
            value = rawDigits,
            onValueChange = { new ->
                val digitsOnly = new.text.filter { it.isDigit() }.take(4)
                rawDigits = TextFieldValue(digitsOnly, selection = TextRange(digitsOnly.length))
            },
            modifier = Modifier
                .focusRequester(focusRequester)
                .size(1.dp)
                .alpha(0f),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = hourText,
                fontSize = 18.sp,
                modifier = Modifier
                    .background(
                        if (parsed.activeSegment == TimeSegment.HOUR) AppColors.Primary.copy(alpha = 0.25f)
                        else Color.Transparent,
                        RoundedCornerShape(4.dp)
                    )
                    .padding(horizontal = 2.dp)
            )
            Text(text = ":", fontSize = 18.sp, modifier = Modifier.padding(horizontal = 2.dp))
            Text(
                text = minuteText,
                fontSize = 18.sp,
                modifier = Modifier
                    .background(
                        if (parsed.activeSegment == TimeSegment.MINUTE) AppColors.Primary.copy(alpha = 0.25f)
                        else Color.Transparent,
                        RoundedCornerShape(4.dp)
                    )
                    .padding(horizontal = 2.dp)
            )
        }
    }
}