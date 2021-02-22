package com.gibran.marvelservice.database.dao

import androidx.room.*
import com.gibran.marvelservice.model.Hero
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface HeroDao {

    @Query("SELECT * FROM ${Hero.TABLE_NAME}")
    fun heroes(): Single<List<Hero>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveHeroes(counter: List<Hero>): Completable

    @Update
    fun favoriteHero(hero: Hero): Completable

}