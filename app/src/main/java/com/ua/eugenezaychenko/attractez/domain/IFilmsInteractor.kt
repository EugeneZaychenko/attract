package com.ua.eugenezaychenko.attractez.domain

import com.ua.eugenezaychenko.attractez.data.repository.models.FilmDataModel
import io.reactivex.Flowable

interface IFilmsInteractor {

    fun getFilmList(): Flowable<List<FilmDataModel>>

}