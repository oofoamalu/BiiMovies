package com.obiomaofoamalu.biimovies.data.repository

import com.obiomaofoamalu.biimovies.data.database.LocalCountryDAO
import com.obiomaofoamalu.biimovies.data.database.LocalGenreDAO
import com.obiomaofoamalu.biimovies.data.service.RemoteCountryDAO
import com.obiomaofoamalu.biimovies.data.service.RemoteGenreDAO
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
}

//endregion