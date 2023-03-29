package com.nasa.voyager.view.resource

import androidx.compose.runtime.staticCompositionLocalOf
import cafe.adriel.lyricist.LanguageTag

internal object Locales {
    const val EN: LanguageTag = "en"
    const val PT: LanguageTag = "pt"
}

internal val strings = mapOf(
    Locales.EN to StringsEn,
    Locales.PT to StringsPt
)

internal val LocalStrings= staticCompositionLocalOf{ StringsEn }