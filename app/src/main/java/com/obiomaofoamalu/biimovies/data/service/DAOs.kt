package com.obiomaofoamalu.biimovies.data.service

import android.support.annotation.VisibleForTesting
import com.obiomaofoamalu.biimovies.data.database.Country
import com.obiomaofoamalu.biimovies.data.database.Genre
import io.reactivex.Observable
import java.util.*
import javax.inject.Inject

//region REMOTE MOVIE DAO --------------------------------------------------------------------------

class RemoteMovieDAO @Inject constructor(private val mBiiService: BiiService,
                                         private val mServiceInfoProvider: ServiceInfoProvider) {

    fun getMovies() = mBiiService.getMovies(mServiceInfoProvider.getApiKey())

    fun getMovieDetails(movieId: Int) =
            mBiiService.getMovieDetails(movieId, mServiceInfoProvider.getApiKey())

}

//endregion

//region REMOTE GENRE DAO --------------------------------------------------------------------------

class RemoteGenreDAO @Inject constructor(private val mBiiService: BiiService,
                                         private val mServiceInfoProvider: ServiceInfoProvider) {

    fun getGenres(): Observable<ArrayList<Genre>> =
            mBiiService.getGenres(mServiceInfoProvider.getApiKey())
                    .map { genreResponse -> genreResponse.genres }
}

//endregion

//region REMOTE COUNTRY DAO ------------------------------------------------------------------------

class RemoteCountryDAO @Inject constructor(private val mBiiService: BiiService,
                                           private val mServiceInfoProvider: ServiceInfoProvider) {

    fun getCountries(): Observable<ArrayList<Country>> =
            mBiiService.getCountries(mServiceInfoProvider.getApiKey())
                    .flatMap { countryResponses -> listOfCountry(countryResponses) }

    @VisibleForTesting
    fun listOfCountry(countryResponses: ArrayList<CountryResponse>):
            Observable<ArrayList<Country>> {

        val countries = ArrayList<Country>(countryResponses.size)

        for (countryResponse in countryResponses) {
            countries.add(Country(countryResponse.id, countryResponse.name))
        }

        return Observable.fromArray(countries)
    }
}

//endregion