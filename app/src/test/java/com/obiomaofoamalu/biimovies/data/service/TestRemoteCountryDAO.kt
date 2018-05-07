package com.obiomaofoamalu.biimovies.data.service

import com.obiomaofoamalu.biimovies.data.database.Country
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class TestRemoteCountryDAO {

    @Mock private lateinit var mService: BiiService
    @Mock private lateinit var mServiceInfoProvider: ServiceInfoProvider

    private lateinit var mRemoteCountryDAO: RemoteCountryDAO

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        initMockBehaviour()
        mRemoteCountryDAO = RemoteCountryDAO(mService, mServiceInfoProvider)
    }

    @Test
    fun getCountries() {
        // GIVEN a testObserver
        val testObserver = TestObserver<ArrayList<Country>>()
        // GIVEN that service.getCountries() returns an Observable of CountryResponses
        val countryResponses = arrayListOf(CountryResponse("NG", "Nigeria"))
        Mockito.`when`(mService.getCountries(anyString()))
                .thenReturn(Observable.fromArray(countryResponses))

        // WHEN we get country list from remote server
        mRemoteCountryDAO.getCountries()
                .safeSubscribe(testObserver)

        // THEN assert that a list of country was emitted
        testObserver.assertValue(arrayListOf(Country("NG", "Nigeria")))
        // THEN verify that service.getCountries() was called
        verify(mService).getCountries(anyString())
    }

    @Test
    fun listOfCountry() {
        // GIVEN an array list of country responses
        val countryResponses = arrayListOf(CountryResponse("NG", "Nigeria"))
        // GIVEN a test observer
        val testObserver = TestObserver<ArrayList<Country>>()

        // WHEN we call listOfCountry() passing in countryResponses and subscribe
        mRemoteCountryDAO.listOfCountry(countryResponses)
                .safeSubscribe(testObserver)

        // THEN verify that result is a list of country
        val result = testObserver.values()[0]
        assertTrue(result[0] is Country)
        assertEquals("NG", result[0].id)
        assertEquals("Nigeria", result[0].name)
    }

    private fun initMockBehaviour() {
        val apiKey = "aisoiajoaoije9092"
        Mockito.`when`(mServiceInfoProvider.getApiKey()).thenReturn(apiKey)
    }
}