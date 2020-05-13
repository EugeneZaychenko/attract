package com.ua.eugenezaychenko.attractez.utils

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Flowable<T>.ioToUi() = subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())