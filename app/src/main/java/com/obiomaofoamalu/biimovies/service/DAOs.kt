package com.obiomaofoamalu.biimovies.service

import javax.inject.Inject

class RemoteMovieDAO @Inject constructor(private val mBiiService: BiiService,
                                         private val mServiceInfoProvider: ServiceInfoProvider) {

    fun getMovies() = mBiiService.getMovies(mServiceInfoProvider.getApiKey())

    fun getMovieDetails(movieId: Int) =
            mBiiService.getMovieDetails(movieId, mServiceInfoProvider.getApiKey())
}

class RemoteGenreDAO @Inject constructor(private val mBiiService: BiiService,
                                         private val mServiceInfoProvider: ServiceInfoProvider) {

    fun getGenres() = mBiiService.getGenres(mServiceInfoProvider.getApiKey())
}

class RemoteCountryDAO @Inject constructor(private val mBiiService: BiiService,
                                           private val mServiceInfoProvider: ServiceInfoProvider) {

    fun getCountries() = mBiiService.getCountries(mServiceInfoProvider.getApiKey())
}