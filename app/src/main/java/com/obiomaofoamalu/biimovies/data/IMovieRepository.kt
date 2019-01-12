package com.obiomaofoamalu.biimovies.data

import com.obiomaofoamalu.biimovies.core.Movie
import io.reactivex.Observable


//todo: kotlin doc
interface IMovieRepository {

    fun getDiscoverMovies(): Observable<List<Movie>>
}


//todo: kotlin doc
class MovieRepository : IMovieRepository {

    override fun getDiscoverMovies(): Observable<List<Movie>> {
        // get from local storage
        // if no data
        // then retrieve from remote
        //todo: implement me
        return Observable.empty()
    }
}