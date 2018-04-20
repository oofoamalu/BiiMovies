package com.obiomaofoamalu.biimovies.injection

import android.arch.persistence.room.Room
import android.content.Context
import android.content.res.Resources
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.obiomaofoamalu.biimovies.BiiApplication
import com.obiomaofoamalu.biimovies.database.BiiDatabase
import com.obiomaofoamalu.biimovies.service.BiiService
import com.obiomaofoamalu.biimovies.service.ServiceInfoProvider
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
class DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(context: Context): BiiDatabase = Room.databaseBuilder(context, BiiDatabase::class.java,
            BiiDatabase.NAME).build()
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