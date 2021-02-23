package com.gibran.marvelservice.api.remote

import com.gibran.marvelservice.api.MarvelDataSource
import com.gibran.marvelservice.model.Hero
import io.reactivex.Single
import kotlinx.serialization.ExperimentalSerializationApi
import timber.log.Timber

@ExperimentalSerializationApi
class MarvelRemoteDataSource(private val service: MarvelService) : MarvelDataSource {
    override fun heroes(): Single<List<Hero>> {
        return service.heroes()
            .map { it.data.results }
            .doOnError { Timber.e(it, "heroes: %s", it.message) }
    }

    override fun heroDetails(hero: Hero): Single<Hero> {
        return service.heroDetails(hero.id)
            .map { it.data.results.first() }
            .doOnError { Timber.e(it, "heroDetails: %s", it.message) }
    }
}
