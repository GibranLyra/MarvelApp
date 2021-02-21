package com.gibran.marvelservice.api.remote

import com.gibran.marvelservice.model.Hero
import com.gibran.marvelservice.model.MarvelData
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.*

interface MarvelService {
    @GET("v1/public/characters")
    fun heroes(): Single<MarvelData<Hero>>

}