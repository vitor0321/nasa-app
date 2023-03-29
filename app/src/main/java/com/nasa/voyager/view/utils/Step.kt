package com.nasa.voyager.view.utils

import cafe.adriel.voyager.core.screen.Screen

abstract class Step(
    private val analyticsName: String,
) : Screen {

    init {
        analyticsName
    }

    override val key: String = ""
}