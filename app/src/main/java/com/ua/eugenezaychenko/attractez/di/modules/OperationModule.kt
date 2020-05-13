package com.ua.eugenezaychenko.attractez.di.modules

import com.ua.eugenezaychenko.attractez.di.scopes.OperationScope
import com.ua.eugenezaychenko.attractez.domain.FilmsInteractor
import com.ua.eugenezaychenko.attractez.domain.IFilmsInteractor
import dagger.Binds
import dagger.Module

@Module
abstract class OperationModule {

    @Binds
    @OperationScope
    abstract fun provideFilmInteractor(filmInteractor: FilmsInteractor): IFilmsInteractor

}