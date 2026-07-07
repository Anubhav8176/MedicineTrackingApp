package com.anucodes.medicinetracker.ui.theme

import androidx.compose.ui.graphics.Color


object AppColors {

    // ── Brand / Primary ───────────────────────────────────────────────────────
    val Primary          = Color(0xFF006A60)   // teal – buttons, active nav, FAB
    val PrimaryVariant   = Color(0xFF009688)   // teal gradient end (progress card)
    val PrimaryContainer = Color(0xFFE0F2EE)   // chip bg, input bg tint
    val OnPrimary        = Color(0xFFFFFFFF)
    val OnPrimaryContainer = Color(0xFF00504A)

    // ── Secondary ─────────────────────────────────────────────────────────────
    val Secondary          = Color(0xFF3D6B9E)  // blue (Lisinopril / moderate adherence)
    val SecondaryContainer = Color(0xFFD8EAF8)
    val OnSecondary        = Color(0xFFFFFFFF)
    val OnSecondaryContainer = Color(0xFF0D3461)

    // ── Tertiary / Accent ─────────────────────────────────────────────────────
    val Tertiary          = Color(0xFF4CAF82)   // accent green
    val TertiaryContainer = Color(0xFFD4F5E5)
    val OnTertiary        = Color(0xFFFFFFFF)

    // ── Error / Destructive ───────────────────────────────────────────────────
    val Error          = Color(0xFFBA1A1A)
    val ErrorContainer = Color(0xFFFFD6D6)
    val OnError        = Color(0xFFFFFFFF)
    val OnErrorContainer = Color(0xFF410002)

    // ── Background & Surface ──────────────────────────────────────────────────
    val Background        = Color(0xFFF5FBF8)   // app background
    val Surface           = Color(0xFFFFFFFF)   // cards
    val SurfaceVariant    = Color(0xFFF0F4F3)   // muted surface, icon chips
    val SurfaceSheet      = Color(0xFFFAFFFD)   // bottom sheet + bottom nav
    val OnBackground      = Color(0xFF161D1B)
    val OnSurface         = Color(0xFF161D1B)
    val OnSurfaceVariant  = Color(0xFF3F4E4B)

    // ── Outline & Divider ─────────────────────────────────────────────────────
    val Outline        = Color(0x14000000)  // rgba(0,0,0,0.08)
    val OutlineVariant = Color(0x0F000000)  // rgba(0,0,0,0.06) – list dividers

    // ── Text ──────────────────────────────────────────────────────────────────
    val TextPrimary   = Color(0xFF161D1B)   // headings, body
    val TextSecondary = Color(0xFF3F4E4B)   // labels, captions, icons
    val TextDisabled  = Color(0xFFB2CCC8)   // placeholder, unchecked toggle

    // ── Status Chips ──────────────────────────────────────────────────────────
    val StatusTakenBg      = Color(0xFFD8F4EE)
    val StatusTakenText    = Color(0xFF006A60)
    val StatusPendingBg    = Color(0xFFFFF3CD)
    val StatusPendingText  = Color(0xFF7C5E00)
    val StatusMissedBg     = Color(0xFFFFD6D6)
    val StatusMissedText   = Color(0xFFBA1A1A)
    val StatusUpcomingBg   = Color(0xFFF0F4F3)
    val StatusUpcomingText = Color(0xFF3F4E4B)

    // ── Medication Category Colors ────────────────────────────────────────────
    val MedDiabetes     = Color(0xFF006A60)  // Metformin
    val MedBloodPressure = Color(0xFF3D6B9E) // Lisinopril
    val MedSupplement   = Color(0xFF7C5E00)  // Vitamin D3 (amber)
    val MedCholesterol  = Color(0xFF8B4A6B)  // Atorvastatin (mauve)
    val MedOmega        = Color(0xFF1A6B2E)  // Omega-3 (forest green)

    // ── Semantic / Indicator ──────────────────────────────────────────────────
    val Streak       = Color(0xFFE65100)   // flame / streak orange
    val Warning      = Color(0xFF7C5E00)   // refill alert, low adherence
    val ProgressBar  = Color(0xFFA7F3D0)   // progress bar fill on dark card

    // ── Overlays ──────────────────────────────────────────────────────────────
    val Scrim            = Color(0x66000000)  // bottom sheet backdrop (40%)
    val HomeIndicator    = Color(0x33000000)  // home gesture bar (20%)
    val SurfaceOverlay   = Color(0x0AFFFFFF)  // subtle white lift on dark

    // ── Page / Wallpaper Gradient ─────────────────────────────────────────────
    val GradientStart  = Color(0xFFC8E6C9)   // light green
    val GradientMid    = Color(0xFFB2DFDB)   // light teal
    val GradientEnd    = Color(0xFFE0F7FA)   // light cyan

    // ── Phone Chrome (mockup only – not needed in production app) ─────────────
    val PhoneBezel     = Color(0xFF1A1A1A)
    val PhoneBezelRing = Color(0xFF333333)
    val PunchHole      = Color(0xFF0A0A0A)

    // ── Switch / Toggle ───────────────────────────────────────────────────────
    val SwitchTrackOn  = Color(0xFF006A60)
    val SwitchTrackOff = Color(0xFFB2CCC8)
    val SwitchThumb    = Color(0xFFFFFFFF)
}