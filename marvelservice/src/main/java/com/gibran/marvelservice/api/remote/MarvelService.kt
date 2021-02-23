package com.gibran.marvelservice.api.remote

import com.gibran.marvelservice.model.Hero
import com.gibran.marvelservice.model.MarvelData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface MarvelService {
    @GET("v1/public/characters")
    fun heroes(): Single<MarvelData<Hero>>

    @GET("v1/public/characters/{heroId}")
    fun heroDetails(@Path("heroId") heroId: Int): Single<MarvelData<Hero>>

}