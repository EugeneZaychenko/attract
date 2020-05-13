package com.ua.eugenezaychenko.attractez.utils.base

import io.reactivex.disposables.CompositeDisposable

interface BasePresenter <T: BaseView> {

    var view: T?

    val compositeDisposable: CompositeDisposable

    fun bindView(view: T)

    fun end ()

}