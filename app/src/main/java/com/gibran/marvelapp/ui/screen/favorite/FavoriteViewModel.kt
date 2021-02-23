package com.gibran.marvelapp.ui.screen.favorite

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gibran.marvelapp.ext.defaultSchedulers
import com.gibran.marvelapp.ui.base.BaseViewModel
import com.gibran.marvelapp.ui.screen.favorite.usecase.FavoriteUseCase
import com.gibran.marvelapp.util.ResultState
import com.gibran.marvelservice.model.Hero

internal class FavoriteViewModel(
    application: Application,
    private val favoriteUseCase: FavoriteUseCase
) : BaseViewModel(application) {

    private val heroesData = MutableLiveData<ResultState<List<Hero>>>()
    val heroes: LiveData<ResultState<List<Hero>>> = heroesData

    private val favoriteData = MutableLiveData<ResultState<Hero>>()
    val favoriteStatus: LiveData<ResultState<Hero>> = favoriteData

    internal fun fetchFavoriteHeroes() {
        favoriteUseCase.fetchFavoriteHeroes()
            .defaultSchedulers()
            .doOnSubscribe { heroesData.value = ResultState.Loading }
            .subscribe { result, _ ->
                when (result) {
                    is ResultState.Success -> heroesData.value = result
                    is ResultState.Error.RecoverableError -> heroesData.value =
                        result.apply { action = { fetchFavoriteHeroes() } }
                    is ResultState.Error.NonRecoverableError -> heroesData.value = result
                    ResultState.Loading -> heroesData.value = result
                }
            }
            .run { disposables.add(this) }
    }

    internal fun hasHeroes(): Boolean {
        return when (heroes.value) {
            is ResultState.Success ->
                (heroes.value as ResultState.Success<List<Hero>>).data.isNotEmpty()
            else -> false
        }
    }

    fun favoriteHero(hero: Hero) {
        favoriteUseCase.favoriteHero(hero)
            .defaultSchedulers()
            .subscribe { result, _ ->
                when (result) {
                    is ResultState.Success -> favoriteData.value = result
                    is ResultState.Error.RecoverableError,
                    is ResultState.Error.NonRecoverableError -> favoriteData.value = result
                    ResultState.Loading -> favoriteData.value = result
                }
            }
            .run { disposables.add(this) }
    }
}