package com.gibran.marvelapp.di

import com.gibran.marvelapp.ui.screen.favorite.FavoriteViewModel
import com.gibran.marvelapp.ui.screen.favorite.usecase.FavoriteUseCase
import com.gibran.marvelapp.ui.screen.herodetail.HeroDetailViewModel
import com.gibran.marvelapp.ui.screen.herodetail.usecase.HeroDetailUseCase
import com.gibran.marvelapp.ui.screen.main.MainViewModel
import com.gibran.marvelapp.ui.screen.main.usecase.HeroesUseCase
import com.gibran.marvelservice.api.MarvelRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppComponent {
    val viewModelModule = module {
        viewModel { MainViewModel(androidApplication(), get()) }
        viewModel { FavoriteViewModel(androidApplication(), get()) }
        viewModel { HeroDetailViewModel(androidApplication(), get()) }
    }

    val useCaseModule = module {
        single { HeroesUseCase(get() as MarvelRepository) }
        single { FavoriteUseCase(get() as MarvelRepository) }
        single { HeroDetailUseCase(get() as MarvelRepository) }
    }
}