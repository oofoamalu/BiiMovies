package com.obiomaofoamalu.biimovies.data.remote

import com.obiomaofoamalu.biimovies.core.Movie
import com.obiomaofoamalu.biimovies.network.IKeyProvider
import com.obiomaofoamalu.biimovies.network.MovieApi
import io.reactivex.Observable
import javax.inject.Inject


//todo: kotlin doc
interface IRemoteMovieRepository {

    fun getDiscoverMovies(): Observable<List<Movie>>
}


//todo: kotlin doc
class RemoteMovieRepository @Inject constructor(
    private val movieApi: MovieApi,
    private val keyProvider: IKeyProvider
) : IRemoteMovieRepository {

    private val apiKey: String = keyProvider.getKey()

    override fun getDiscoverMovies(): Observable<List<Movie>> {
        return movieApi.getDiscoverMovies(apiKey)
            .map { it.movies }
            .
    }
}