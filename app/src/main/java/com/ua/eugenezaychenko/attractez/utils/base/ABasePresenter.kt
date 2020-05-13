package com.ua.eugenezaychenko.attractez.utils.base

import io.reactivex.disposables.CompositeDisposable

abstract class ABasePresenter<T : BaseView> : BasePresenter<T> {

    override var view: T? = null
    override val compositeDisposable = CompositeDisposable()

    override fun bindView(view: T) {
        this.view = view
    }

    override fun end() {
        view = null
        compositeDisposable.clear()
    }

}