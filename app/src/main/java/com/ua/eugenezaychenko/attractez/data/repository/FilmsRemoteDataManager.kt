package com.ua.eugenezaychenko.attractez.data.repository

import com.ua.eugenezaychenko.attractez.data.IAttractService
import com.ua.eugenezaychenko.attractez.data.repository.models.FilmDataModel
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.ResponseBody
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FilmsRemoteDataManager @Inject constructor(private val attractService: IAttractService) :
        IFilmsRemoteDataManager {

    override fun getFilms(): Single<List<FilmDataModel>> {
        return attractService.getFilms()
    }

    override fun downloadImg(filmDataItem: FilmDataModel): Observable<Pair<FilmDataModel, ResponseBody?>> {
        return attractService.downloadImg(filmDataItem.imgURL)
                .map { Pair(filmDataItem, it.body()) }
    }
}