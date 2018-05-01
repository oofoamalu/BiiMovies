package com.obiomaofoamalu.biimovies.data.service

import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class TestRemoteCountryDAO {

    @Mock
    private lateinit var mService: BiiService
    @Mock
    private lateinit var mServiceInfoProvider: ServiceInfoProvider

    private lateinit var mRemoteCountryDAO: RemoteCountryDAO

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        initMockBehaviour()
        mRemoteCountryDAO = RemoteCountryDAO(mService, mServiceInfoProvider)
    }

    @Test
    fun getCountries() {
        // GIVEN a test observer
        val testObserver = TestObserver<ArrayList<CountryResponse>>()

        // WHEN we call getCountries() and subscribe to it
        mRemoteCountryDAO.getCountries()
                .safeSubscribe(testObserver)

        // THEN assert that one item was emitted
        testObserver.assertValueCount(1)
        // THEN assert that emitted item was array list of CountryResponse
        val result = testObserver.values()[0]
        assertTrue(result is ArrayList<CountryResponse>)
    }

    private fun initMockBehaviour() {
        val apiKey = "aisoiajoaoije9092"
        val countryResponse = CountryResponse("ng", "Nigeria")
        val countryObservable = Observable.fromArray(arrayListOf(countryResponse))

        Mockito.`when`(mServiceInfoProvider.getApiKey()).thenReturn(apiKey)
        Mockito.`when`(mService.getCountries(apiKey)).thenReturn(countryObservable)
    }
}