package com.obiomaofoamalu.biimovies.data.repository

import com.obiomaofoamalu.biimovies.data.database.Country
import com.obiomaofoamalu.biimovies.data.database.LocalCountryDAO
import com.obiomaofoamalu.biimovies.data.service.RemoteCountryDAO
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class TestCountryRepository {

    @Mock private lateinit var mRemoteCountryDAO: RemoteCountryDAO
    @Mock private lateinit var mLocalCountryDAO: LocalCountryDAO

    private lateinit var mRepository: CountryRepository

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        mRepository = CountryRepository(mRemoteCountryDAO, mLocalCountryDAO)
    }

    @Test
    fun getCountries_savesToDatabase() {
        // GIVEN remote country dao returns a observable of countries
        val countries = arrayListOf(Country("NG", "Nigeria"),
                Country("KE", "Kenya"))
        Mockito.`when`(mRemoteCountryDAO.getCountries()).thenReturn(Observable.fromArray(countries))

        // WHEN we call getCountries()
        mRepository.getCountries()

        // THEN verify that returned countries was saved in database
        verify(mLocalCountryDAO, after(1000)).saveCountries(countries)
    }
}