package com.nasa.voyager

import android.app.Application
import com.nasa.voyager.di.coroutinesModule
import com.nasa.voyager.di.networkModule
import com.nasa.voyager.di.repositoryModule
import com.nasa.voyager.di.viewModelModule
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