package com.gibran.marvelservice.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gibran.marvelservice.model.Hero
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface HeroDao {

    @Query("SELECT * FROM ${Hero.TABLE_NAME}")
    fun heroes(): Single<List<Hero>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCounters(counter: List<Hero>): Completable

}