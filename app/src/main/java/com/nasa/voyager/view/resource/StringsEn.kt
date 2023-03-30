package com.nasa.voyager.view.resource

import cafe.adriel.lyricist.LyricistStrings

@LyricistStrings(languageTag = Locales.EN, default = true)
internal val StringsEn = Strings(
    astronomy = Astronomy(
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
    components = Components(
        textClick = "Click here to see the video",
    )
)
