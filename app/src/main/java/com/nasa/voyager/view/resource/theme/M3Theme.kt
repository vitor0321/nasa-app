package com.nasa.voyager.view.resource.theme

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nasa.astronomy.view.resource.theme.ExtendedColors

@Composable
fun NasaBasicTheme(
    isDynamic: Boolean = true,
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val systemUiController = rememberSystemUiController()
    val useDynamicColor = isDynamic && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    val extendedColors = if (useDarkTheme) darkExtendedColors else lightExtendedColors

    val colors = if (useDynamicColor) {
        val context = LocalContext.current
        if (useDarkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    } else {
        if (useDarkTheme) DarkThemeColors else LightThemeColors
    }

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = colors.primary
        )
    }

    CompositionLocalProvider(LocalExtendedColors provides extendedColors) {
        MaterialTheme(
            colorScheme = colors,
            typography = AppDefaultTypography,
            shapes = M3DefaultShapes,
            content = content
        )
    }
}

object NasaThemeExtended {
    val typography: AppCustomTypography
        @Composable
        get() = AppCustomTypography

    val colors: ExtendedColors
        @Composable
        get() = LocalExtendedColors.current
}

@Preview
@Composable
fun LightColorsPreview() {
    NasaBasicTheme(useDarkTheme = false) {
        ColorList()
    }
}

@Preview
@Composable
fun DarkColorsPreview() {
    NasaBasicTheme(useDarkTheme = true) {
        ColorList()
    }
}

@Composable
fun ColorList() {
    Column(
        modifier = Modifier
            .verticalScroll(state = rememberScrollState())
            .fillMaxHeight()
    ) {
        mapOf(
            "primary" to MaterialTheme.colorScheme.primary,
            "primaryVariant" to MaterialTheme.colorScheme.primaryContainer,
            "primarySurface" to MaterialTheme.colorScheme.onPrimaryContainer,
            "onPrimary" to MaterialTheme.colorScheme.onPrimary,
            "inversePrimary" to MaterialTheme.colorScheme.inversePrimary,

            "secondary" to MaterialTheme.colorScheme.secondary,
            "onSecondary" to MaterialTheme.colorScheme.onSecondary,
            "secondaryVariant" to MaterialTheme.colorScheme.secondaryContainer,
            "onSecondaryContainer" to MaterialTheme.colorScheme.onSecondaryContainer,

            "tertiary" to MaterialTheme.colorScheme.tertiary,
            "onTertiary" to MaterialTheme.colorScheme.onTertiary,
            "tertiaryContainer" to MaterialTheme.colorScheme.tertiaryContainer,
            "onTertiaryContainer" to MaterialTheme.colorScheme.onTertiaryContainer,

            "background" to MaterialTheme.colorScheme.background,
            "onBackground" to MaterialTheme.colorScheme.onBackground,

            "surface" to MaterialTheme.colorScheme.surface,
            "onSurface" to MaterialTheme.colorScheme.onSurface,
            "surfaceVariant" to MaterialTheme.colorScheme.surfaceVariant,
            "onSurfaceVariant" to MaterialTheme.colorScheme.onSurfaceVariant,
            "surfaceTint" to MaterialTheme.colorScheme.surfaceTint,
            "inverseSurface" to MaterialTheme.colorScheme.inverseSurface,
            "inverseOnSurface" to MaterialTheme.colorScheme.inverseOnSurface,

            "error" to MaterialTheme.colorScheme.error,
            "onError" to MaterialTheme.colorScheme.onError,
            "errorContainer" to MaterialTheme.colorScheme.errorContainer,
            "onErrorContainer" to MaterialTheme.colorScheme.onErrorContainer,
            "outline" to MaterialTheme.colorScheme.outline,

            // custom extented colors
            "customSnowWhite" to NasaThemeExtended.colors.snowWhite,
            "customDeepOcean" to NasaThemeExtended.colors.deepOcean,
            "customSkyBlue" to NasaThemeExtended.colors.skyBlue,
            "customNightBlue" to NasaThemeExtended.colors.nightBlue,
            "customDialogBackground" to NasaThemeExtended.colors.dialogBackground,
        ).forEach { (text, color) ->
            Row {
                Text(
                    text = text,
                    color = NasaThemeExtended.colors.snowWhite,
                    modifier = Modifier
                        .weight(1f)
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(32.dp)
                        .background(color)
                )
            }
        }
    }
}