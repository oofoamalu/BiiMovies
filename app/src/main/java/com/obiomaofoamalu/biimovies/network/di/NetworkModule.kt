package com.obiomaofoamalu.biimovies.network.di

import com.obiomaofoamalu.biimovies.network.MovieApi
import com.obiomaofoamalu.biimovies.network.BiiApiFactory
import com.obiomaofoamalu.biimovies.network.IKeyProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//todo: kotlin doc
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesBiiApi(): MovieApi = BiiApiFactory.createMovieApi()

    @Provides
    fun provides
}
