package com.ua.eugenezaychenko.attractez.data.repository

import com.ua.eugenezaychenko.attractez.data.repository.models.FilmDataModel
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.ResponseBody

interface IFilmsRemoteDataManager {

    fun getFilms(): Single<List<FilmDataModel>>

    fun downloadImg(filmDataItem: FilmDataModel): Observable<Pair<FilmDataModel, ResponseBody?>>

}