package com.ua.eugenezaychenko.attractez.data.repository

import com.ua.eugenezaychenko.attractez.data.repository.models.FilmDataModel
import io.reactivex.Flowable

interface IFilmsRepository {

    fun getFilmList(): Flowable<List<FilmDataModel>>

}