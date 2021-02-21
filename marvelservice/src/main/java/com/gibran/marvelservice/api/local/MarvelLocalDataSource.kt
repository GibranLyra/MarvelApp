package com.gibran.marvelservice.api.local

import com.gibran.marvelservice.database.dao.HeroDao


class MarvelLocalDataSource(private val heroDao: HeroDao) : HeroDatabaseDataSource {
    override fun heroDao() = heroDao

    override fun heroes() = heroDao.heroes()

}