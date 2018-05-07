package com.obiomaofoamalu.biimovies.launch

import com.obiomaofoamalu.biimovies.data.repository.CountryRepository
import com.obiomaofoamalu.biimovies.data.repository.GenreRepository
import javax.inject.Inject

class LaunchViewModel @Inject constructor(private val mGenreRepository: GenreRepository,
                                          private val mCountryRepository: CountryRepository) {

    fun getCountriesIfNecessary() {
        if (!mCountryRepository.hasCountries()) {
            mCountryRepository.getCountries()
        }
    }

    fun getGenresIfNecessary() {
        if (!mGenreRepository.hasGenres()) {
            mGenreRepository.getGenres()
        }
    }
}