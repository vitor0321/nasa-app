package com.nasa.nasaApp

import android.app.Application
import com.nasa.nasaApp.di.coroutinesModule
import com.nasa.nasaApp.di.networkModule
import com.nasa.nasaApp.di.repositoryModule
import com.nasa.nasaApp.di.viewModelModule
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.bind
import org.kodein.di.conf.ConfigurableDI
import org.kodein.di.provider

class NasaApp : Application(), DIAware {

    private val appModule = DI.Module(name = "application") {
        bind<Application>() with provider {
            this@NasaApp
        }
    }

    override val di = ConfigurableDI(mutable = true).apply {
        addImport(appModule)
        loadAppModules()
    }

}


internal fun ConfigurableDI.loadAppModules() {
    addImport(coroutinesModule)
    addImport(networkModule)
    addImport(repositoryModule)
    addImport(viewModelModule)
}