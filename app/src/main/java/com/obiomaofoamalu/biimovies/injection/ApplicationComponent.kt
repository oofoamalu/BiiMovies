package com.obiomaofoamalu.biimovies.injection

import com.obiomaofoamalu.biimovies.launch.LaunchActivity
import com.obiomaofoamalu.biimovies.movielist.MovieList
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules=arrayOf(ApplicationModule::class, DataModule::class, NetworkModule::class))
interface ApplicationComponent {

    fun inject(activity: LaunchActivity)
    fun inject(activity: MovieList)
}