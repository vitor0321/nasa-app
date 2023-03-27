package com.nasa.nasaApp.view.resource

import cafe.adriel.lyricist.LyricistStrings

@LyricistStrings(languageTag = Locales.EN, default = true)
internal val StringsEn = Strings(
    components = Components(
        loading = "loading...",
        error = "hummm... something wrong",
        astronomyPictureOfDay = "Astronomy Picture of the Day",
        discoverTheCosmos = """Discover the cosmos! 
            |Each day a different image or photograph 
            |of our fascinating universe is featured, 
            |along with a brief explanation written by 
            |a professional astronomer.""".trimMargin(),
        copyright = "Credit and Copyright: ",
        video = "Video:  ",
        selectDate = "select date",
        cancel = "Cancel",
        ok = "OK",
    ),
)
