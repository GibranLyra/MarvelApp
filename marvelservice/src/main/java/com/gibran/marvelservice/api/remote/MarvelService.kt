package com.gibran.marvelservice.api.remote

import com.gibran.marvelservice.model.Hero
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.*

interface MarvelService {
    @GET("v1/public/characters?apikey=468470cb48e5cf4f799c5e456d618593")
    fun heroes(): Single<List<Hero>>

}