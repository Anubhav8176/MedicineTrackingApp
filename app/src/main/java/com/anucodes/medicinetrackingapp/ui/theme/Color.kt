package com.anucodes.medicinetrackingapp.ui.theme

import androidx.compose.ui.graphics.Color

// ─────────────────────────────────────────────
//  Raw Palette  (from Coolors palette)
// ─────────────────────────────────────────────
val AliceBlue  = Color(0xFFE0FBFC)   // lightest — barely-blue white
val PowderBlue = Color(0xFFC2DFE3)   // light steel blue
val CadetBlue  = Color(0xFF9DB4C0)   // muted mid-tone
val PaynesGray = Color(0xFF5C6B73)   // slate gray
val Gunmetal   = Color(0xFF253237)   // deep dark teal

// ─────────────────────────────────────────────
//  Derived / Blended Values
// ─────────────────────────────────────────────
val AliceBlueDarker   = Color(0xFFCBF0F2)   // slightly deeper surface
val GunmetalLight     = Color(0xFF344049)   // lighter gunmetal for dark mode surfaces
val GunmetalLighter   = Color(0xFF445059)   // card surfaces in dark mode

// ─────────────────────────────────────────────
//  Status Colors  (harmonised with palette)
// ─────────────────────────────────────────────
val DoseTakenGreen    = Color(0xFF4CAF82)   // calm teal-green
val DoseMissedRed     = Color(0xFFD97B6C)   // muted coral-red
val DoseUpcoming      = CadetBlue
val DoseSnoozedAmber  = Color(0xFFD4A259)   // warm amber, medicine-safe

// ─────────────────────────────────────────────
//  AppColors  — named semantic tokens
// ─────────────────────────────────────────────
object AppColors {

    // Backgrounds
    val background        = AliceBlue
    val backgroundDark    = Gunmetal
    val surface           = Color(0xFFEEF8F9)    // cards / sheets (light)
    val surfaceDark       = GunmetalLight         // cards / sheets (dark)
    val surfaceVariant    = PowderBlue            // alternate surface (light)
    val surfaceVariantDark = GunmetalLighter      // alternate surface (dark)

    // Primary actions
    val primary           = Gunmetal
    val primaryLight      = PaynesGray
    val onPrimary         = AliceBlue             // text/icons on primary buttons
    val primaryContainer  = PowderBlue            // filled chip / FAB container (light)
    val primaryContainerDark = GunmetalLight
    val onPrimaryContainer = Gunmetal

    // Secondary
    val secondary         = CadetBlue
    val onSecondary       = Gunmetal
    val secondaryContainer = AliceBlueDarker
    val onSecondaryContainer = PaynesGray

    // Text
    val textPrimary       = Gunmetal
    val textPrimaryDark   = AliceBlue
    val textSecondary     = PaynesGray
    val textSecondaryDark = CadetBlue
    val textHint          = CadetBlue
    val textHintDark      = PaynesGray
    val textOnPrimary     = AliceBlue
    val textLink          = PaynesGray

    // Icons
    val iconPrimary       = Gunmetal
    val iconPrimaryDark   = AliceBlue
    val iconSecondary     = PaynesGray
    val iconSecondaryDark = CadetBlue
    val iconDisabled      = CadetBlue

    // Borders & Dividers
    val border            = PowderBlue
    val borderDark        = PaynesGray
    val divider           = Color(0x33253237)     // Gunmetal @ 20% alpha (light)
    val dividerDark       = Color(0x339DB4C0)     // CadetBlue @ 20% alpha (dark)

    // Input fields
    val inputBackground   = Color(0xFFF0F9FA)
    val inputBackgroundDark = GunmetalLighter
    val inputBorder       = CadetBlue
    val inputBorderFocused = Gunmetal
    val inputText         = Gunmetal
    val inputTextDark     = AliceBlue
    val inputHint         = CadetBlue
    val inputCursor       = Gunmetal

    // Navigation
    val navBarBackground  = Gunmetal
    val navBarSelected    = AliceBlue
    val navBarUnselected  = CadetBlue
    val navBarIndicator   = PaynesGray

    // App Bar
    val appBarBackground  = Gunmetal
    val appBarContent     = AliceBlue

    // Buttons
    val buttonPrimary         = Gunmetal
    val buttonPrimaryText     = AliceBlue
    val buttonSecondary       = Color.Transparent
    val buttonSecondaryBorder = Gunmetal
    val buttonSecondaryText   = Gunmetal
    val buttonDisabled        = CadetBlue
    val buttonDisabledText    = PowderBlue

    // Cards
    val cardBackground        = Color(0xFFEEF8F9)
    val cardBackgroundDark    = GunmetalLight
    val cardBorder            = PowderBlue
    val cardBorderDark        = PaynesGray

    // ── Medicine-specific status ──────────────────
    val doseTaken      = DoseTakenGreen
    val doseMissed     = DoseMissedRed
    val doseUpcoming   = DoseUpcoming
    val doseSnoozed    = DoseSnoozedAmber
    val doseSkipped    = CadetBlue

    val doseTakenContainer  = Color(0xFF1E3D31)
    val doseMissedContainer = Color(0xFF3D2420)
    val onDoseTaken         = Color(0xFFA8ECCE)
    val onDoseMissed        = Color(0xFFEFBDB4)

    // Alert / Badge
    val alertBadge     = DoseMissedRed
    val onAlertBadge   = Color(0xFFFFFFFF)

    // Scrim / Overlay
    val scrim          = Color(0x80253237)   // Gunmetal @ 50%
}