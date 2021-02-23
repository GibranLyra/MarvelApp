package com.gibran.marvelapp.ui.screen.favorite.usecase

import com.gibran.marvelapp.util.ResultState
import com.gibran.marvelservice.api.MarvelDataSource
import com.gibran.marvelservice.model.Hero
import io.reactivex.Single
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketException
import java.net.UnknownHostException

class FavoriteUseCase(private val marvelDataSource: MarvelDataSource) {

    fun fetchFavoriteHeroes(): Single<ResultState<List<Hero>>> {
        return marvelDataSource.heroes()
            .map { it.filter { hero -> hero.isFavorited } }
            .map { ResultState.Success(it) as ResultState<List<Hero>> }
            .onErrorReturn { handleError(it) }
    }

    fun favoriteHero(hero: Hero): Single<ResultState<Hero>> {
        return marvelDataSource.favoriteHero(hero)
            .toSingle{ ResultState.Success(hero) as ResultState<Hero> }
            .onErrorReturn { handleError(it) }
    }

    /* Simple implementation just to show how to Handle two type of Exceptions,
    * an Recoverable Error can be a TimeOut for example */
    private fun handleError(throwable: Throwable) = when (throwable) {
        is HttpException, is SocketException, is UnknownHostException -> ResultState.Error.RecoverableError(throwable)
        else -> ResultState.Error.NonRecoverableError(throwable)
    }
}