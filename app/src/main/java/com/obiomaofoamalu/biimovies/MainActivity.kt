package com.obiomaofoamalu.biimovies

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.obiomaofoamalu.biimovies.di.Injector
import com.obiomaofoamalu.biimovies.movielist.IMovieListNavigator
import com.obiomaofoamalu.biimovies.movielist.MovieListFragment
import com.obiomaofoamalu.biimovies.network.MovieApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

//todo: kotlin doc
class MainActivity : AppCompatActivity(), IMainViewNavigator {

    @Inject
    lateinit var api: MovieApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Injector.applicationComponent.inject(this)
        addMovieListFragment()
    }

    @SuppressLint("CheckResult")
    override fun onResume() {
        super.onResume()
        api.getDiscoverMovies("b61967ad00f7ba1d19ac793d904ef1c3")
            .map { it.movies }
            .subscribeOn(Schedulers.io())
            .subscribe { println(it) }
    }

    override fun addMovieDetailsFragment(id: String) {
        // todo: show movie details fragment
    }

    private fun addMovieListFragment() {
        supportFragmentManager.apply {
            beginTransaction()
                .add(R.id.fragmentContainer, MovieListFragment.newInstance())
                .commitNow()
        }
    }

    companion object {

        //todo: kotlin doc
        fun startActivity(invokingActivity: AppCompatActivity) {
            val intent = Intent(invokingActivity, MainActivity::class.java)
            invokingActivity.startActivity(intent)
        }
    }
}

//todo: kotlin doc
interface IMainViewNavigator : IMovieListNavigator
