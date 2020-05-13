package com.ua.eugenezaychenko.attractez.domain

import com.ua.eugenezaychenko.attractez.data.repository.IFilmsRepository
import com.ua.eugenezaychenko.attractez.data.repository.models.FilmDataModel
import io.reactivex.Flowable
import javax.inject.Inject

class FilmsInteractor @Inject constructor(private val repository: IFilmsRepository) : IFilmsInteractor {

    override fun getFilmList(): Flowable<List<FilmDataModel>> = repository.getFilmList()
            .map { addItemForTest(it) }


    //This is function need for test task
    private fun addItemForTest(it: List<FilmDataModel>): MutableList<FilmDataModel> {
        val list = it.toMutableList()
        for (i in 1..4) {
            list.addAll(it)
        }
        return list
    }

}