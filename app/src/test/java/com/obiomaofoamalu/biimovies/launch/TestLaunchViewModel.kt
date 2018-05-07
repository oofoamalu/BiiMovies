package com.obiomaofoamalu.biimovies.launch

import com.obiomaofoamalu.biimovies.data.repository.CountryRepository
import com.obiomaofoamalu.biimovies.data.repository.GenreRepository
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class TestLaunchViewModel {

    @Mock private lateinit var mGenreRepository: GenreRepository
    @Mock private lateinit var mCountryRepository: CountryRepository

    private lateinit var mViewModel: LaunchViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        mViewModel = LaunchViewModel(mGenreRepository, mCountryRepository)
    }

    @Test
    fun getCountriesIfNecessary_getsCountries() {
        // GIVEN that no countries has been saved in database
        Mockito.`when`(mCountryRepository.hasCountries()).thenReturn(false)

        // WHEN we call getCountriesIfNecessary()
        mViewModel.getCountriesIfNecessary()

        // THEN verify that countries was retrieved from remote server
        verify(mCountryRepository).getCountries()
    }

    @Test
    fun getCountriesIfNecessary_doesNotGetCountries() {
        // GIVEN that we have country info in database
        Mockito.`when`(mCountryRepository.hasCountries()).thenReturn(true)

        // WHEN we call getCountriesIfNecessary()
        mViewModel.getCountriesIfNecessary()

        // THEN verify that countries was not retrieved from remote server
        verify(mCountryRepository, times(0)).getCountries()
    }

    @Test
    fun getGenresIfNecessary_getsGenres() {
        // GIVEN that no genre has been saved in database
        Mockito.`when`(mGenreRepository.hasGenres()).thenReturn(false)

        // WHEN we call getGenresIfNecessary()
        mViewModel.getGenresIfNecessary()

        // THEN verify that genres was retrieved from remote server
        verify(mGenreRepository).getGenres()
    }

    @Test
    fun getGenresIfNecessary_doesNotGetGenres() {
        // GIVEN that we have genre info in database
        Mockito.`when`(mGenreRepository.hasGenres()).thenReturn(true)

        // WHEN we call getGenresIfNecessary()
        mViewModel.getGenresIfNecessary()

        // THEN verify that genres was not retrieved from remote server
        verify(mGenreRepository, times(0)).getGenres()
    }
}