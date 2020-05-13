package com.ua.eugenezaychenko.attractez.data.repository

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.ua.eugenezaychenko.attractez.data.repository.db.dao.FilmDao
import com.ua.eugenezaychenko.attractez.data.repository.managers.IBitmapManager
import com.ua.eugenezaychenko.attractez.data.repository.models.FilmDataModel
import com.ua.eugenezaychenko.attractez.utils.NoInternetConnection
import com.ua.eugenezaychenko.attractez.utils.isOnline
import com.ua.eugenezaychenko.attractez.utils.toFilmDataModelList
import com.ua.eugenezaychenko.attractez.utils.toFilmEntityList
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class FilmsRepository @Inject constructor(private val context: Context,
                                          private val bitmapManager: IBitmapManager,
                                          private val remoteDataManager: IFilmsRemoteDataManager,
                                          private val filmDao: FilmDao) : IFilmsRepository {

    private var imgMap = linkedMapOf<String, Bitmap>()

    override fun getFilmList(): Flowable<List<FilmDataModel>> {
        return filmDao.getAllFilms()
                .map { it.toFilmDataModelList(imgMap) }
                .flatMap { list: List<FilmDataModel> ->
                    return@flatMap when {
                        list.isEmpty() -> downloadFilmsData()
                        imgMap.isEmpty() -> downloadImg(list).toFlowable()
                        else -> Flowable.just(list)
                    }
                }
    }

    private fun downloadFilmsData(): Flowable<List<FilmDataModel>> {
        return if (!context.isOnline()) throw NoInternetConnection()
        else remoteDataManager.getFilms()
                .flatMap { list: List<FilmDataModel> -> downloadImg(list) }
                .toFlowable()
    }

    private fun downloadImg(list: List<FilmDataModel>): Single<List<FilmDataModel>> {
        return if (bitmapManager.isImgInStorageAvailable(list, imgMap) || !context.isOnline()) Single.just(list)
        else Observable.fromArray(list)
                .map { modelList -> modelList.distinctBy { it.itemID } }
                .flatMap { urlList: List<FilmDataModel> -> Observable.fromIterable(urlList) }
                .flatMap { filmItem: FilmDataModel -> remoteDataManager.downloadImg(filmItem) }
                .map { pair ->
                    val filmDataModel = pair.first
                    val body = pair.second
                    body?.let {
                        val input = it.byteStream()
                        val bitmap = BitmapFactory.decodeStream(input)
                        imgMap[filmDataModel.itemID] = bitmap
                        bitmapManager.saveBitmapInInternalStorage(bitmap, filmDataModel)
                    }
                    filmDataModel
                }.toList()
                .map { filmList ->
                    val filmEntityList = filmList.toFilmEntityList()
                    filmDao.addFilmList(filmEntityList)
                    filmList
                }
    }

}