package com.ua.eugenezaychenko.attractez.di.components

import com.ua.eugenezaychenko.attractez.di.modules.FilmInfoModule
import com.ua.eugenezaychenko.attractez.di.scopes.FilmInfoScope
import com.ua.eugenezaychenko.attractez.ui.film_info.FilmPagerFragment
import dagger.Subcomponent


@Subcomponent(modules = [FilmInfoModule::class])
@FilmInfoScope
interface FilmInfoComponent {

    fun inject(filmPagerFragment: FilmPagerFragment)

}