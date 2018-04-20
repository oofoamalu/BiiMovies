package com.obiomaofoamalu.biimovies.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters

@Database(entities = arrayOf(Movie::class, Genre::class, Country::class), version = 1)
@TypeConverters(Converters::class)
abstract class BiiDatabase : RoomDatabase() {

    companion object {
        val NAME: String = BiiDatabase::class.java.simpleName
    }

    abstract fun movieDAO(): MovieDAO

    abstract fun genreDAO(): GenreDAO

    abstract fun countryDAO(): CountryDAO
}