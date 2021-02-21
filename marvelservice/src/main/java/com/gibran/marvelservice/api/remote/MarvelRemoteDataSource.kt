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
            .doOnError { Timber.e(it, "heroes: %s", it.message) }
    }

}
