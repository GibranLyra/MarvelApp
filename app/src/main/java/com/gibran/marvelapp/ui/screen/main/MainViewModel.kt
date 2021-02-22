package com.gibran.marvelapp.ui.screen.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gibran.marvelapp.ext.defaultSchedulers
import com.gibran.marvelapp.ui.base.BaseViewModel
import com.gibran.marvelapp.ui.screen.main.usecase.MarvelHeroesUseCase
import com.gibran.marvelapp.util.ResultState
import com.gibran.marvelservice.model.Hero

internal class MainViewModel(
    application: Application,
    private val marvelHeroesUseCase: MarvelHeroesUseCase
) : BaseViewModel(application) {

    private val heroesData = MutableLiveData<ResultState<List<Hero>>>()
    val heroes: LiveData<ResultState<List<Hero>>> = heroesData

    private val favoriteData = MutableLiveData<ResultState<Hero>>()
    val favoriteStatus: LiveData<ResultState<Hero>> = favoriteData

    internal fun fetchHeroes() {
        marvelHeroesUseCase.fetchHeroes()
            .defaultSchedulers()
            .doOnSubscribe { heroesData.value = ResultState.Loading }
            .subscribe { result, _ ->
                when (result) {
                    is ResultState.Success -> heroesData.value = result
                    is ResultState.Error.RecoverableError,
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

    fun getLoadedHeroes(): List<Hero> {
        return when (heroes.value) {
            is ResultState.Success -> (heroes.value as ResultState.Success<List<Hero>>).data
            else -> listOf()
        }
    }

    fun favoriteHero(hero: Hero) {
        marvelHeroesUseCase.favoriteHero(hero)
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