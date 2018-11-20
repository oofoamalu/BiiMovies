package com.obiomaofoamalu.biimovies.data.repository

import com.obiomaofoamalu.biimovies.data.database.LocalCountryDAO
import com.obiomaofoamalu.biimovies.data.database.LocalGenreDAO
import com.obiomaofoamalu.biimovies.data.database.LocalMovieDAO
import com.obiomaofoamalu.biimovies.data.database.Movie
import com.obiomaofoamalu.biimovies.data.service.RemoteCountryDAO
import com.obiomaofoamalu.biimovies.data.service.RemoteGenreDAO
import com.obiomaofoamalu.biimovies.data.service.RemoteMovieDAO
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

//region COUNTRY REPOSITORY ------------------------------------------------------------------------

class CountryRepository @Inject constructor(private val mRemoteCountryDAO: RemoteCountryDAO,
                                            private val mLocalCountryDAO: LocalCountryDAO) {

    fun getCountries() {
        mRemoteCountryDAO.getCountries()
                .subscribeOn(Schedulers.io())
                .subscribe { countries -> mLocalCountryDAO.saveCountries(countries) }
    }

    fun hasCountries(): Boolean {
        return mLocalCountryDAO.getCountries()
                .subscribeOn(Schedulers.io())
                .blockingGet()
                .isNotEmpty()
    }
}

//endregion

//region GENRE REPOSITORY --------------------------------------------------------------------------

class GenreRepository @Inject constructor(private val mRemoteGenreDAO: RemoteGenreDAO,
                                          private val mLocalGenreDAO: LocalGenreDAO) {
    fun getGenres() {
        mRemoteGenreDAO.getGenres()
                .subscribeOn(Schedulers.io())
                .subscribe { genres -> mLocalGenreDAO.saveGenres(genres) }
    }

    fun hasGenres(): Boolean {
        return mLocalGenreDAO.getGenres()
                .subscribeOn(Schedulers.io())
                .blockingGet()
                .isNotEmpty()
    }
}

//endregion

//region MOVIE REPOSITORY --------------------------------------------------------------------------

class MovieRepository @Inject constructor(private val mRemoteMovieDAO: RemoteMovieDAO,
                                          private val mLocalMovieDAO: LocalMovieDAO) {

    fun getMovies() {
        //todo: include pagination
        mRemoteMovieDAO.getMovies()
                .subscribeOn(Schedulers.io())
                .subscribe { movies -> mLocalMovieDAO.saveMovies(movies) }
    }

    fun getMovieListData(): Flowable<List<Movie>> {
        return mLocalMovieDAO.getMovies()
                .subscribeOn(Schedulers.io())
    }
}
//endregion