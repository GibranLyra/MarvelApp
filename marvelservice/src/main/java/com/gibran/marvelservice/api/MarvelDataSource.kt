package com.gibran.marvelservice.api

import com.gibran.marvelservice.model.Hero
import io.reactivex.Single

interface MarvelDataSource {
    fun heroes(): Single<Hero>
}
