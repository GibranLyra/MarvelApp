package com.gibran.marvelservice.api

import com.gibran.marvelservice.model.Hero
import io.reactivex.Completable
import io.reactivex.Single

interface MarvelDataSource {
    fun heroes(): Single<List<Hero>>
    fun favoriteHero(hero: Hero) = Completable.complete()
    fun heroDetails(hero: Hero): Single<Hero> = Single.error(NotImplementedError())
}
