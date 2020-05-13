package com.ua.eugenezaychenko.attractez.di.modules

import com.ua.eugenezaychenko.attractez.di.scopes.FilmListScope
import com.ua.eugenezaychenko.attractez.ui.film_list.FilmListContract
import com.ua.eugenezaychenko.attractez.ui.film_list.FilmListPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class FilmListModule {

    @Binds
    @FilmListScope
    abstract fun provideFilmListPresenter(filmListPresenter: FilmListPresenter): FilmListContract.Presenter
}