package com.ua.eugenezaychenko.attractez.di.components

import android.app.Application
import com.ua.eugenezaychenko.attractez.App
import com.ua.eugenezaychenko.attractez.di.modules.AndroidModule
import com.ua.eugenezaychenko.attractez.di.modules.DataModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [
    AndroidModule::class,
    DataModule::class
])

@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun app(application: Application): Builder

        fun build(): AppComponent

    }

    fun inject(app: App)

    fun provideOperationComponent(): OperationComponent

}