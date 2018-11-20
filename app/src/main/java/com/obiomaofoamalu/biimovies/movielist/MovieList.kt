package com.obiomaofoamalu.biimovies.movielist

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.obiomaofoamalu.biimovies.R
import com.obiomaofoamalu.biimovies.data.repository.MovieRepository
import com.obiomaofoamalu.biimovies.databinding.ActivityMovieListBinding
import com.obiomaofoamalu.biimovies.injection.Injector
import com.obiomaofoamalu.biimovies.movielist.adapter.MovieListAdapter
import javax.inject.Inject

class MovieList : AppCompatActivity() {

    //region INJECTED CLASSES ----------------------------------------------------------------------

    @Inject
    lateinit var mMovieRepository: MovieRepository

    //endregion

    //region CLASS VARIABLES -----------------------------------------------------------------------

    private lateinit var mBinding: ActivityMovieListBinding

    //endregion

    //region CONSTRUCTOR ---------------------------------------------------------------------------

    companion object {
        fun start(invokingActivity: Activity) {
            val intent = Intent(invokingActivity, MovieList::class.java)
            invokingActivity.startActivity(intent)
        }
    }

    //endregion

    //region LIFECYCLE METHODS ---------------------------------------------------------------------

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie_list)
        Injector.applicationComponent.inject(this)

        initView()
    }

    override fun onResume() {
        super.onResume()
        mMovieRepository.getMovies()
    }

    //endregion

    //region PRIVATE CLASS METHODS -----------------------------------------------------------------

    private fun initView() {
        mBinding.recyclerView.adapter = MovieListAdapter(mMovieRepository)
        mBinding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    //endregion
}
