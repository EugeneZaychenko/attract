package com.ua.eugenezaychenko.attractez.di.components

import com.ua.eugenezaychenko.attractez.di.modules.OperationModule
import com.ua.eugenezaychenko.attractez.di.scopes.OperationScope
import com.ua.eugenezaychenko.attractez.ui.OperationActivity
import dagger.Subcomponent

@Subcomponent(modules = [OperationModule::class])
@OperationScope
interface OperationComponent {

    fun inject(operationActivity: OperationActivity)

    fun provideFilmListComponent(): FilmListComponent

    fun provideFilmInfoComponent(): FilmInfoComponent


}