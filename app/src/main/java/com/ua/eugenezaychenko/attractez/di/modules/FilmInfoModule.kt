package com.ua.eugenezaychenko.attractez.di.modules

import com.ua.eugenezaychenko.attractez.di.scopes.FilmInfoScope
import com.ua.eugenezaychenko.attractez.ui.film_info.FilmPagerContract
import com.ua.eugenezaychenko.attractez.ui.film_info.FilmPagerPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class FilmInfoModule {

    @Binds
    @FilmInfoScope
    abstract fun providePagerFragmentPresenter(filmPagerPresenter: FilmPagerPresenter): FilmPagerContract.Presenter

}