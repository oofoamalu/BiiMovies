package com.obiomaofoamalu.biimovies.data.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy

@Dao
interface LocalMovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovies(movies: List<Movie>)
}

@Dao
interface LocalGenreDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveGenres(genres: List<Genre>)
}

@Dao
interface LocalCountryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCountries(countries: List<Country>)
}