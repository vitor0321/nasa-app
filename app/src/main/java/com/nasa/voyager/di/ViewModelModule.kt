package com.nasa.voyager.di

import com.nasa.voyager.domain.data.CoroutinesDispatchers
import com.nasa.voyager.domain.AstronomyDataSource
import com.nasa.voyager.domain.AsteroidsDataSource
import com.nasa.voyager.view.steps.AsteroidsViewModel
import com.nasa.voyager.view.steps.AstronomyViewModel
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.instance

val viewModelModule = DI.Module(name = "viewModelModule") {

    bindProvider { AsteroidsViewModel(instance<AsteroidsDataSource>(), instance<CoroutinesDispatchers>()) }
    bindProvider { AstronomyViewModel(instance<AstronomyDataSource>(), instance<CoroutinesDispatchers>()) }
}
