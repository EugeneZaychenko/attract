package com.ua.eugenezaychenko.attractez.ui.film_info

import com.ua.eugenezaychenko.attractez.domain.IFilmsInteractor
import com.ua.eugenezaychenko.attractez.utils.base.ABasePresenter
import com.ua.eugenezaychenko.attractez.utils.ioToUi
import com.ua.eugenezaychenko.attractez.utils.toFilmInfoModelList
import javax.inject.Inject

class FilmPagerPresenter @Inject constructor(private val interactor: IFilmsInteractor)
    : FilmPagerContract.Presenter, ABasePresenter<FilmPagerContract.View>() {

    override fun init() {
        compositeDisposable.add(interactor.getFilmList()
                .ioToUi()
                .subscribe({
                    view?.updatePagerList(it.toFilmInfoModelList())
                }, { error -> error.message?.let { view?.showError(it) } }))
    }

}