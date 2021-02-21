package com.gibran.marvelapp.ext

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun ui(): Scheduler = AndroidSchedulers.mainThread()

fun <T> Single<T>.defaultSchedulers(): Single<T> =
    subscribeOn(Schedulers.io())
        .observeOn(ui())