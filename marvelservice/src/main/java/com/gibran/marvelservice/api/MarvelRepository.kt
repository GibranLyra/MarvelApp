package com.gibran.marvelservice.api

import com.gibran.marvelservice.api.local.HeroDatabaseDataSource
import com.gibran.marvelservice.model.Hero
import io.reactivex.Completable
import io.reactivex.Single

class MarvelRepository(
    private val remoteRepo: MarvelDataSource,
    private val localRepo: HeroDatabaseDataSource
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
                    .flatMapCompletable { heroes -> refreshLocalDataSource(heroes) }
                    .toSingle { cacheIsDirty = false }
                    .flatMap { localRepo.heroes() }
                    .map {
                        refreshMemoryCache(it)
                        it
                    }
                    .onErrorResumeNext { ex ->
                        cacheIsDirty = true
                        when {
                            cachedHeroes.isNotEmpty() -> Single
                                .fromCallable { cachedHeroes.values.toList() }
                            else -> localRepo.heroes()
                                .flatMap { heroes ->
                                    if (heroes.isNotEmpty()) {
                                        Single.fromCallable { heroes }
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

    override fun favoriteHero(hero: Hero): Completable {
        cacheIsDirty = true
        return localRepo.favoriteHero(hero)
    }

    override fun heroDetails(hero: Hero) = remoteRepo.heroDetails(hero)
        .map { it.copy(isFavorited = hero.isFavorited) }

    private fun refreshMemoryCache(heroes: List<Hero>) {
        cachedHeroes.clear()
        heroes.forEachIndexed { index, counter ->
            cachedHeroes[index] = counter
        }
        cacheIsDirty = false
    }

    private fun refreshLocalDataSource(heroes: List<Hero>) = localRepo.heroDao()
        .saveHeroes(heroes)
}
