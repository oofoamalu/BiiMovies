package com.obiomaofoamalu.biimovies.data.repository

import com.obiomaofoamalu.biimovies.data.database.Genre
import com.obiomaofoamalu.biimovies.data.database.LocalGenreDAO
import com.obiomaofoamalu.biimovies.data.service.RemoteGenreDAO
import io.reactivex.Maybe
import io.reactivex.Observable
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class TestGenreRepository {

    @Mock private lateinit var mRemoteGenreDAO: RemoteGenreDAO
    @Mock private lateinit var mLocalGenreDAO: LocalGenreDAO

    private lateinit var mRepository: GenreRepository

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        mRepository = GenreRepository(mRemoteGenreDAO, mLocalGenreDAO)
    }

    @Test
    fun getGenres_savesToDatabase() {
        // GIVEN that remote genre dao returns an observable of genres
        val genres = arrayListOf(Genre(1, "Action"),
                Genre(2, "Adventure"))
        Mockito.`when`(mRemoteGenreDAO.getGenres()).thenReturn(Observable.fromArray(genres))

        // WHEN we call getGenres()
        mRepository.getGenres()

        // THEN verify that returned genres was saved to database
        verify(mLocalGenreDAO, after(1000)).saveGenres(genres)
    }

    @Test
    fun hasGenres_returnsTrue() {
        // GIVEN that we have data stored in the genre table
        Mockito.`when`(mLocalGenreDAO.getGenres())
                .thenReturn(Maybe.just(listOf(Genre(12, "Action"))))

        // WHEN we call hasGenres()
        val result = mRepository.hasGenres()

        // THEN assert that result is true
        assertTrue(result)
    }

    @Test
    fun hasGenres_returnsFalse() {
        // GIVEN that there are no data stored in the genre table
        Mockito.`when`(mLocalGenreDAO.getGenres()).thenReturn(Maybe.just(listOf()))

        // WHEN we call hasGenres()
        val result = mRepository.hasGenres()

        // THEN assert that result is false
        assertFalse(result)
    }
}