package com.gibran.marvelapp.ui.screen.main.usecase

import com.gibran.marvelapp.util.ResultState
import com.gibran.marvelservice.api.MarvelDataSource
import com.gibran.marvelservice.model.Hero
import io.reactivex.Single
import retrofit2.HttpException
import java.net.ConnectException

class MarvelHeroesUseCase(private val marvelDataSource: MarvelDataSource) {

    fun fetchHeroes(): Single<ResultState<List<Hero>>> {
        return marvelDataSource.heroes()
            .map { ResultState.Success(it) as ResultState<List<Hero>> }
            .onErrorReturn { handleError(it) }
    }

    fun favoriteHero(hero: Hero): Single<ResultState<Hero>> {
        return marvelDataSource.favoriteHero(hero)
            .toSingle{ ResultState.Success(hero) as ResultState<Hero>  }
            .onErrorReturn { handleError(it) }
    }

    /* Simple implementation just to show how to Handle two type of Exceptions,
    * an Recoverable Error can be a TimeOut for example */
    private fun handleError(throwable: Throwable) = when (throwable) {
        is HttpException, is ConnectException -> ResultState.Error.RecoverableError(throwable)
        else -> ResultState.Error.NonRecoverableError(throwable)
    }
}
