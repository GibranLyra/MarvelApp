package com.gibran.marvelapp.ui.screen.herodetail

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gibran.marvelapp.ext.defaultSchedulers
import com.gibran.marvelapp.ui.base.BaseViewModel
import com.gibran.marvelapp.ui.screen.herodetail.usecase.HeroDetailUseCase
import com.gibran.marvelapp.util.ResultState
import com.gibran.marvelservice.model.Hero

class HeroDetailViewModel(
    application: Application,
    private val heroDetailUseCase: HeroDetailUseCase
) : BaseViewModel(application) {

    private val heroData = MutableLiveData<ResultState<Hero>>()
    val hero: LiveData<ResultState<Hero>> = heroData

    fun fetchHeroDetail(hero: Hero) {
        heroDetailUseCase.fetchHeroDetails(hero)
            .defaultSchedulers()
            .doOnSubscribe { heroData.value = ResultState.Loading }
            .subscribe { result, _ ->
                when (result) {
                    is ResultState.Success -> heroData.value = result
                    is ResultState.Error.RecoverableError -> heroData.value =
                        result.apply { action = { fetchHeroDetail(hero) } }
                    is ResultState.Error.NonRecoverableError -> heroData.value = result
                    ResultState.Loading -> heroData.value = result
                }
            }
            .run { disposables.add(this) }
    }
}