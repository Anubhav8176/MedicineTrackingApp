package com.anucodes.medicinetrackingapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary              = CadetBlue,
    onPrimary            = Gunmetal,
    primaryContainer     = PaynesGray,
    onPrimaryContainer   = AliceBlue,

    secondary            = PowderBlue,
    onSecondary          = Gunmetal,
    secondaryContainer   = GunmetalLight,
    onSecondaryContainer = CadetBlue,

    tertiary             = AliceBlue,
    onTertiary           = Gunmetal,
    tertiaryContainer    = GunmetalLighter,
    onTertiaryContainer  = PowderBlue,

    background           = Gunmetal,
    onBackground         = AliceBlue,

    surface              = GunmetalLight,
    onSurface            = AliceBlue,
    surfaceVariant       = GunmetalLighter,
    onSurfaceVariant     = CadetBlue,

    outline              = PaynesGray,
    outlineVariant       = GunmetalLighter,

    error                = DoseMissedRed,
    onError              = Gunmetal,
    errorContainer       = Color(0xFF93000A),
    onErrorContainer     = Color(0xFFFFDAD6),

    inverseSurface       = PowderBlue,
    inverseOnSurface     = Gunmetal,
    inversePrimary       = Gunmetal,
    scrim                = Color(0x80000000),
)

private val LightColorScheme = lightColorScheme(
    primary              = Gunmetal,
    onPrimary            = AliceBlue,
    primaryContainer     = PowderBlue,
    onPrimaryContainer   = Gunmetal,

    secondary            = CadetBlue,
    onSecondary          = Gunmetal,
    secondaryContainer   = AliceBlueDarker,
    onSecondaryContainer = PaynesGray,

    tertiary             = PaynesGray,
    onTertiary           = AliceBlue,
    tertiaryContainer    = PowderBlue,
    onTertiaryContainer  = Gunmetal,

    background           = AliceBlue,
    onBackground         = Gunmetal,

    surface              = Color(0xFFEEF8F9),
    onSurface            = Gunmetal,
    surfaceVariant       = PowderBlue,
    onSurfaceVariant     = PaynesGray,

    outline              = CadetBlue,
    outlineVariant       = PowderBlue,

    error                = DoseMissedRed,
    onError              = Color.White,
    errorContainer       = Color(0xFFFFDAD6),
    onErrorContainer     = Color(0xFF410002),

    inverseSurface       = Gunmetal,
    inverseOnSurface     = AliceBlue,
    inversePrimary       = CadetBlue,
    scrim                = Color(0x80253237),
)

@Composable
fun MedicineTrackingAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    // Set false to always use our custom palette instead of Material You
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    // Tint the status bar to match the app bar
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat
                .getInsetsController(window, view)
                .isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}