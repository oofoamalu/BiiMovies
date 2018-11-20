package com.obiomaofoamalu.biimovies.data.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import io.reactivex.Maybe

@Dao
interface LocalMovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovies(movies: List<Movie>)

    @Query("SELECT id, title, releaseYear, rating, posterPath FROM Movies")
    fun getMovies(): Flowable<List<Movie>>
}

@Dao
interface LocalGenreDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveGenres(genres: List<Genre>)

    @Query("SELECT * FROM Genres")
    fun getGenres(): Maybe<List<Genre>>
}

@Dao
interface LocalCountryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCountries(countries: List<Country>)

    @Query("SELECT * FROM Countries")
    fun getCountries(): Maybe<List<Country>>
}