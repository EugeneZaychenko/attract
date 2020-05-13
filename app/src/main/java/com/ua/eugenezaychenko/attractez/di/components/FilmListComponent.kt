package com.ua.eugenezaychenko.attractez.di.components

import com.ua.eugenezaychenko.attractez.di.modules.FilmListModule
import com.ua.eugenezaychenko.attractez.di.scopes.FilmListScope
import com.ua.eugenezaychenko.attractez.ui.film_list.FilmListFragment
import dagger.Subcomponent


@Subcomponent(modules = [FilmListModule::class])
@FilmListScope
interface FilmListComponent {

    fun inject(filmListFragment: FilmListFragment)

}