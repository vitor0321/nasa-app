package com.nasa.nasaApp.di

import com.nasa.nasaApp.domain.data.CoroutinesDispatchers
import com.nasa.nasaApp.domain.AstronomyDataSource
import com.nasa.nasaApp.domain.AsteroidsDataSource
import com.nasa.nasaApp.view.steps.AsteroidsViewModel
import com.nasa.nasaApp.view.steps.AstronomyViewModel
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.instance

val viewModelModule = DI.Module(name = "viewModelModule") {

    bindProvider { AsteroidsViewModel(instance<AsteroidsDataSource>(), instance<CoroutinesDispatchers>()) }
    bindProvider { AstronomyViewModel(instance<AstronomyDataSource>(), instance<CoroutinesDispatchers>()) }
}
