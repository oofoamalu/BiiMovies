package com.obiomaofoamalu.biimovies.data.service

import com.obiomaofoamalu.biimovies.data.database.Genre
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
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
        // GIVEN  a testObserver
        val testObserver = TestObserver<ArrayList<Genre>>()
        // GIVEN that mService.getGenres() returns an Observable of genreResponse
        val genreResponses = GenreResponse(arrayListOf(Genre(1, "Action")))
        Mockito.`when`(mService.getGenres(anyString())).thenReturn(Observable.just(genreResponses))

        // WHEN we get genres from remote server and subscribe
        mRemoteGenreDAO.getGenres()
                .safeSubscribe(testObserver)

        // THEN assert that a list of Genre was emitted
        testObserver.assertValue(arrayListOf(Genre(1, "Action")))
        // THEN verify that mService.getGenres() was called
        verify(mService).getGenres(anyString())
    }

    private fun initMockBehaviour() {
        val apiKey = "aisoiajoaoije9092"

        Mockito.`when`(mServiceInfoProvider.getApiKey()).thenReturn(apiKey)
    }
}