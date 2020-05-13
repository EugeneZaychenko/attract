package com.ua.eugenezaychenko.attractez.ui.film_info

import com.ua.eugenezaychenko.attractez.ui.film_info.models.FilmInfoModel
import com.ua.eugenezaychenko.attractez.utils.base.BasePresenter
import com.ua.eugenezaychenko.attractez.utils.base.BaseView

interface FilmPagerContract {

    interface View : BaseView {

        fun updatePagerList(filmIdList: List<FilmInfoModel>)

    }

    interface Presenter : BasePresenter<View> {

        fun init()

    }

}