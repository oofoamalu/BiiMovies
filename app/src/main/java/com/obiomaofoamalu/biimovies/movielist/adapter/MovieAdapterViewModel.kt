package com.obiomaofoamalu.biimovies.movielist.adapter

import com.obiomaofoamalu.biimovies.data.database.Movie
import com.obiomaofoamalu.biimovies.data.repository.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers

class MovieAdapterViewModel(private val mMovieRepository: MovieRepository) {

    var movieList: ArrayList<Movie> = ArrayList()

    init {
        getMovieLiveData()
    }

    fun getMovieLiveData() {
        mMovieRepository.getMovieListData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { movies -> movieList.clear(); movieList.addAll(movies)}
    }
}