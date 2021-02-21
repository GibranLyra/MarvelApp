package com.gibran.marvelservice.api.local

import com.gibran.marvelservice.api.MarvelDataSource
import com.gibran.marvelservice.database.dao.HeroDao

interface HeroDatabaseDataSource : MarvelDataSource {
    fun heroDao(): HeroDao
}