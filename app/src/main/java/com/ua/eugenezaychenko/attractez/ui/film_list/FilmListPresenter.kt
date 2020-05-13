package com.ua.eugenezaychenko.attractez.ui.film_list

import com.ua.eugenezaychenko.attractez.domain.IFilmsInteractor
import com.ua.eugenezaychenko.attractez.utils.base.ABasePresenter
import com.ua.eugenezaychenko.attractez.utils.toFilmItemList
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class FilmListPresenter @Inject constructor(private val interactor: IFilmsInteractor) :
        FilmListContract.Presenter, ABasePresenter<FilmListContract.View>() {

    override fun init() {
        getFilmList()
    }

    private fun getFilmList() {
        compositeDisposable.add(interactor.getFilmList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val filmItemList = it.toFilmItemList()
                    view?.updateFilList(filmItemList)
                }, ::handelError))
    }

    private fun handelError(error: Throwable) {
        error.message?.let { view?.showError(it) }
    }

}