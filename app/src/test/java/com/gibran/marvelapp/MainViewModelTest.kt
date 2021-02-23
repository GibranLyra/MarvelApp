package com.gibran.marvelapp

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.gibran.marvelapp.ui.screen.main.MainViewModel
import com.gibran.marvelapp.ui.screen.main.usecase.HeroesUseCase
import com.gibran.marvelapp.util.ResultState
import com.gibran.marvelservice.api.MarvelDataSource
import com.gibran.marvelservice.model.Hero
import com.nhaarman.mockitokotlin2.*
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    //region Rules
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()
    //endregion Rules

    //region Helper Fields
    private val applicationMock = mock<Application>()

    private val heroesDataSourceMock = mock<MarvelDataSource>()

    private val heroLiveMock = mock<Observer<ResultState<List<Hero>>>>()

    private val heroUseCase = HeroesUseCase(heroesDataSourceMock)
    //endregion Helper Fields

    private val SUT by lazy { MainViewModel(applicationMock, heroUseCase) }

    @Before
    fun setup() {
        /* To simplify the test setup the Schedulers in the setup, the ideal approach would be create a
        * @Rule to RxSchedulers and declare it im the Rules section */
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @Test
    fun onInit_loadHeroes_success() {
        //given
        whenever(heroesDataSourceMock.heroes())
            .thenReturn(Single.just(mock()))
        SUT.heroes.observeForever(heroLiveMock)
        // when
        SUT.fetchHeroes()

        //then
        inOrder(heroLiveMock) {
            verify(heroLiveMock).onChanged(isA<ResultState.Loading>())
            verify(heroLiveMock).onChanged(isA<ResultState.Success<List<Hero>>>())
            verifyNoMoreInteractions(heroLiveMock)
        }
    }

    @Test
    fun onInit_loadHeroes_error() {
        //given
        whenever(heroesDataSourceMock.heroes())
            .thenReturn(Single.error(NotImplementedError("A test error.")))
        SUT.heroes.observeForever(heroLiveMock)
        // when
        SUT.fetchHeroes()

        //then
        inOrder(heroLiveMock) {
            verify(heroLiveMock).onChanged(isA<ResultState.Loading>())
            verify(heroLiveMock).onChanged(isA<ResultState.Error.NonRecoverableError>())
            verifyNoMoreInteractions(heroLiveMock)
        }
    }
}