package com.anucodes.medicinetracker.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

val MedTrackLightColorScheme = lightColorScheme(
    primary              = AppColors.Primary,
    onPrimary            = AppColors.OnPrimary,
    primaryContainer     = AppColors.PrimaryContainer,
    onPrimaryContainer   = AppColors.OnPrimaryContainer,
    secondary            = AppColors.Secondary,
    onSecondary          = AppColors.OnSecondary,
    secondaryContainer   = AppColors.SecondaryContainer,
    onSecondaryContainer = AppColors.OnSecondaryContainer,
    tertiary             = AppColors.Tertiary,
    onTertiary           = AppColors.OnTertiary,
    tertiaryContainer    = AppColors.TertiaryContainer,
    onTertiaryContainer  = AppColors.OnTertiary,
    error                = AppColors.Error,
    onError              = AppColors.OnError,
    errorContainer       = AppColors.ErrorContainer,
    onErrorContainer     = AppColors.OnErrorContainer,
    background           = AppColors.Background,
    onBackground         = AppColors.OnBackground,
    surface              = AppColors.Surface,
    onSurface            = AppColors.OnSurface,
    surfaceVariant       = AppColors.SurfaceVariant,
    onSurfaceVariant     = AppColors.OnSurfaceVariant,
    outline              = AppColors.Outline,
    outlineVariant       = AppColors.OutlineVariant,
    scrim                = AppColors.Scrim,
)

val MedTrackDarkColorScheme = darkColorScheme(
    primary              = Color(0xFF4DD8C8),
    onPrimary            = Color(0xFF003731),
    primaryContainer     = Color(0xFF00504A),
    onPrimaryContainer   = Color(0xFFA7F3D0),
    secondary            = Color(0xFF90B9DC),
    onSecondary          = Color(0xFF003A5C),
    secondaryContainer   = Color(0xFF1A4F74),
    onSecondaryContainer = Color(0xFFD0E8F8),
    tertiary             = Color(0xFF6EDBA0),
    onTertiary           = Color(0xFF003921),
    tertiaryContainer    = Color(0xFF005231),
    onTertiaryContainer  = Color(0xFFB0F5CF),
    error                = Color(0xFFFFB4AB),
    onError              = Color(0xFF690005),
    errorContainer       = Color(0xFF93000A),
    onErrorContainer     = Color(0xFFFFDAD6),
    background           = Color(0xFF0F1C1A),
    onBackground         = Color(0xFFE0FBEF),
    surface              = Color(0xFF161D1B),
    onSurface            = Color(0xFFE0FBEF),
    surfaceVariant       = Color(0xFF1E2C29),
    onSurfaceVariant     = Color(0xFFBFCDC9),
    outline              = Color(0xFF3F4E4B),
    outlineVariant       = Color(0xFF2A3532),
    scrim                = Color(0xFF000000),
)

@Composable
fun MedicineTrackerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> MedTrackDarkColorScheme   // ← was: DarkColorScheme
        else      -> MedTrackLightColorScheme  // ← was: LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography  = Typography,
        content     = content
    )
}