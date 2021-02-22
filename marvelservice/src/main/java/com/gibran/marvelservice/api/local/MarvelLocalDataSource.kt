package com.gibran.marvelservice.api.local

import com.gibran.marvelservice.database.dao.HeroDao
import com.gibran.marvelservice.model.Hero
import io.reactivex.Completable


class MarvelLocalDataSource(private val heroDao: HeroDao) : HeroDatabaseDataSource {
    override fun heroDao() = heroDao

    override fun heroes() = heroDao.heroes()
    override fun favoriteHero(hero: Hero): Completable {
        return heroDao.favoriteHero(hero)
    }

}