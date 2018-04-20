package com.obiomaofoamalu.biimovies.launch.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(Movie::class, Genre::class, Country::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDAO(): MovieDAO

    abstract fun genreDAO(): GenreDAO

    abstract fun countryDAO(): CountryDAO
}