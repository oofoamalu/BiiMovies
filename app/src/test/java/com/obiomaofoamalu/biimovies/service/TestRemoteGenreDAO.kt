package com.obiomaofoamalu.biimovies.service

import com.obiomaofoamalu.biimovies.database.Genre
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class TestRemoteGenreDAO {

    @Mock private lateinit var mService: BiiService
    @Mock private lateinit var mServiceInfoProvider: ServiceInfoProvider

    private lateinit var mRemoteGenreDAO: RemoteGenreDAO

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        initMockBehaviour()
        mRemoteGenreDAO = RemoteGenreDAO(mService, mServiceInfoProvider)
    }

    @Test
    fun getGenres() {
        // GIVEN a test observer
        val testObserver = TestObserver<GenreResponse>()

        // WHEN we call getGenres() and subscribe to it
        mRemoteGenreDAO.getGenres()
                .safeSubscribe(testObserver)

        // THEN assert that one item was emitted
        testObserver.assertValueCount(1)
        // THEN assert that emitted item was GenreResponse
        val result = testObserver.values()[0]
        assertTrue(result is GenreResponse)
    }

    private fun initMockBehaviour() {
        val apiKey = "aisoiajoaoije9092"
        val genre = Genre(1, "Action")
        val genreResponse = GenreResponse(arrayListOf(genre))
        val genreObservable = Observable.just(genreResponse)

        Mockito.`when`(mServiceInfoProvider.getApiKey()).thenReturn(apiKey)
        Mockito.`when`(mService.getGenres(apiKey)).thenReturn(genreObservable)
    }
}