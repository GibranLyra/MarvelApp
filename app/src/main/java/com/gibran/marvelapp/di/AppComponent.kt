package com.gibran.marvelapp.di

import com.gibran.marvelapp.ui.screen.main.MainViewModel
import com.gibran.marvelapp.ui.screen.main.usecase.MarvelHeroesUseCase
import com.gibran.marvelservice.api.MarvelRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppComponent {
    val viewModelModule = module {
        viewModel { MainViewModel(androidApplication(), get()) }
    }

    val useCaseModule = module {
        single { MarvelHeroesUseCase(get() as MarvelRepository) }
    }
}