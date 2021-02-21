package com.gibran.marvelservice.api

import com.gibran.marvelservice.model.Hero
import io.reactivex.Completable
import io.reactivex.Single

class MarvelRepository(
    private val remoteRepo: MarvelDataSource,
    private val localRepo: MarvelDataSource
) : MarvelDataSource {

    var cachedHeroes: LinkedHashMap<Int, Hero> = LinkedHashMap()

    var cacheIsDirty = true

    override fun heroes(): Single<List<Hero>> {
        return when {
            cachedHeroes.isNotEmpty() && !cacheIsDirty -> {
                Single.fromCallable { cachedHeroes.values.toList() }
            }

            cacheIsDirty ->
                remoteRepo.heroes()
                    .flatMap { heroes ->
                        refreshMemoryCache(heroes)
                        refreshLocalDataSource(heroes)
                            .toSingle { heroes }
                    }
                    .map { counters ->
                        cacheIsDirty = false
                        counters
                    }
                    .onErrorResumeNext { ex ->
                        cacheIsDirty = true
                        when {
                            cachedHeroes.isNotEmpty() -> Single
                                .fromCallable { cachedHeroes.values.toList() }
                            else -> localRepo.heroes()
                                .flatMap { counters ->
                                    if (counters.isNotEmpty()) {
                                        Single.fromCallable { counters }
                                    } else {
                                        Single.error(ex)
                                    }
                                }
                        }
                    }

            else -> {
                localRepo.heroes()
            }
        }
    }

    private fun refreshMemoryCache(counters: List<Hero>) {
        cachedHeroes.clear()
        counters.forEachIndexed { index, counter ->
            cachedHeroes[index] = counter
        }
        cacheIsDirty = false
    }

    private fun refreshLocalDataSource(heroes: List<Hero>): Completable {
        //TODO
        return Completable.complete()
    }
}
