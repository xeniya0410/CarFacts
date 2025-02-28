package com.example.carfacts.ui.theme

import android.content.res.Configuration
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColors = lightColorScheme(
    primary = Color(0xFF1565C0),
    secondary = Color(0xFF64B5F6),
    surfaceVariant = Color(0xFFE3F2FD)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF90CAF9),
    secondary = Color(0xFFBBDEFB),
    surfaceVariant = Color(0xFF1E1E1E)
)

@Composable
fun CarFactsTheme(content: @Composable () -> Unit) {
    val context = LocalContext.current
    val isDarkTheme = context.resources.configuration.uiMode and
            Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES

    val colors = if (isDarkTheme) DarkColors else LightColors

    MaterialTheme(colorScheme = colors, typography = Typography, content = content)
}
