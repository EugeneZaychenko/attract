package com.ua.eugenezaychenko.attractez

import android.app.Application
import com.ua.eugenezaychenko.attractez.di.components.*

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
                .builder()
                .app(this)
                .build()
        appComponent.inject(this)

    }

    companion object {

        lateinit var appComponent: AppComponent

        var operationComponent: OperationComponent? = null
            get() {
                if (field == null)
                    field = appComponent.provideOperationComponent()
                return field
            }

        var filmListComponent: FilmListComponent? = null
            get() {
                if (field == null)
                    field = operationComponent?.provideFilmListComponent()
                return field
            }

        var filmInfoComponent: FilmInfoComponent? = null
            get() {
                if (field == null)
                    field = operationComponent?.provideFilmInfoComponent()
                return field
            }
    }
}