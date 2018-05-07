package com.obiomaofoamalu.biimovies.injection

import android.arch.persistence.room.Room
import android.content.Context
import android.content.res.Resources
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.obiomaofoamalu.biimovies.BiiApplication
import com.obiomaofoamalu.biimovies.data.database.BiiDatabase
import com.obiomaofoamalu.biimovies.data.database.LocalCountryDAO
import com.obiomaofoamalu.biimovies.data.database.LocalGenreDAO
import com.obiomaofoamalu.biimovies.data.database.LocalMovieDAO
import com.obiomaofoamalu.biimovies.data.service.*
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val mApplication: BiiApplication) {

    @Provides
    @Singleton
    fun providesApplication() = mApplication

    @Provides
    @Singleton
    fun providesContext(application: BiiApplication): Context = application.applicationContext

    @Provides
    @Singleton
    fun providesResources(context: Context): Resources = context.resources
}

@Module
class DataModule {

    @Provides
    @Singleton
    fun providesDatabase(context: Context): BiiDatabase = Room.databaseBuilder(context,
            BiiDatabase::class.java, BiiDatabase.NAME).build()

    @Provides
    @Singleton
    fun providesLocalCountryDAO(database: BiiDatabase): LocalCountryDAO = database.countryDAO()

    @Provides
    @Singleton
    fun providesLocalGenreDAO(database: BiiDatabase): LocalGenreDAO = database.genreDAO()

    @Provides
    @Singleton
    fun providesLocalMovieDAO(database: BiiDatabase): LocalMovieDAO = database.movieDAO()
}

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(serviceInfoProvider: ServiceInfoProvider): Retrofit = Retrofit.Builder()
            .baseUrl(serviceInfoProvider.getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providesBiiService(retrofit: Retrofit): BiiService = retrofit.create(BiiService::class.java)
}