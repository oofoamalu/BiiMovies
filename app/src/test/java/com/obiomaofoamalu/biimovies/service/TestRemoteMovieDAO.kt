package com.obiomaofoamalu.biimovies.service

import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class TestRemoteMovieDAO {

    @Mock private lateinit var mService: BiiService
    @Mock private lateinit var mServiceInfoProvider: ServiceInfoProvider

    private lateinit var mRemoteMovieDAO: RemoteMovieDAO

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        initMockBehaviour()
        mRemoteMovieDAO = RemoteMovieDAO(mService, mServiceInfoProvider)
    }

    @Test
    fun getMovies() {
        // GIVEN a test observer
        val testObserver = TestObserver<DiscoverMovieResponse>()

        // WHEN we call getMovies() and subscribe to the observable
        mRemoteMovieDAO.getMovies()
                .safeSubscribe(testObserver)

        // THEN assert that emission was completed
        testObserver.assertComplete()
        // THEN assert that one item was emitted
        testObserver.assertValueCount(1)
        // THEN assert emitted item is DiscoveryMovieResponse
        val result = testObserver.values()[0]
        assertTrue(result is DiscoverMovieResponse)
    }

    @Test
    fun getMoveDetails() {
        // GIVEN a movie id
        val movieId = 33175
        // GIVEN a test observer
        val testObserver = TestObserver<MovieDetailResponse>()

        // WHEN we call getMovieDetails() and subscribe to the observable
        mRemoteMovieDAO.getMovieDetails(movieId)
                .safeSubscribe(testObserver)

        // THEN assert that emission was completed
        testObserver.assertComplete()
        // THEN assert that one item was emitted
        testObserver.assertValueCount(1)
        // THEN assert that emitted item is MovieDetailResponse
        val result = testObserver.values()[0]
        assertTrue(result is MovieDetailResponse)
    }

    private fun initMockBehaviour() {
        val apiKey = "aisoiajoaoije9092"
        val movieId = 33175
        val movieResponse = MovieResponse(movieId, "Fifty Shades of Grey",
                "this is an awesome movie", 7.8, "/jaAsX382aje.jpeg",
                "/eiaoisEto42A.jpeg", "2018-08-12", arrayListOf(12,3,4))
        val discoverMovieResponse = DiscoverMovieResponse(arrayListOf(movieResponse))
        val moviesObservable = Observable.just(discoverMovieResponse)

        val countryResponse = CountryResponse("ng", "Nigeria")
        val movieDetailResponse = MovieDetailResponse(106, arrayListOf(countryResponse))
        val movieDetailObservable = Observable.just(movieDetailResponse)

        Mockito.`when`(mServiceInfoProvider.getApiKey()).thenReturn(apiKey)
        Mockito.`when`(mService.getMovies(apiKey)).thenReturn(moviesObservable)
        Mockito.`when`(mService.getMovieDetails(movieId, apiKey)).thenReturn(movieDetailObservable)
    }
}