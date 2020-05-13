package com.ua.eugenezaychenko.attractez.ui.film_list

import com.ua.eugenezaychenko.attractez.ui.film_list.model.FilmListItemModel
import com.ua.eugenezaychenko.attractez.utils.base.BasePresenter
import com.ua.eugenezaychenko.attractez.utils.base.BaseView

interface FilmListContract {

    interface View : BaseView {

        fun updateFilList(filmList: List<FilmListItemModel>)

        fun showProgressBar()

        fun hideProgressBar()

    }

    interface Presenter : BasePresenter<View> {

        fun init()

    }

}