package com.nasa.voyager.view.resource

internal data class Strings(
    val astronomy: Astronomy,
    val components: Components,
)

internal data class Astronomy(
    val loading: String,
    val error: String,
    val astronomyPictureOfDay: String,
    val discoverTheCosmos: String,
    val copyright: String,
    val video: String,
    val selectDate: String,
    val cancel: String,
    val ok: String,
)

internal data class Components(
    val textClick: String,
)
