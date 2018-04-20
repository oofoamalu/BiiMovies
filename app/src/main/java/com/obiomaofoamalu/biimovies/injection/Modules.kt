package com.obiomaofoamalu.biimovies.injection

import android.arch.persistence.room.Room
import android.content.Context
import com.obiomaofoamalu.biimovies.BiiApplication
import com.obiomaofoamalu.biimovies.database.BiiDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val mApplication: BiiApplication) {

    @Provides
    @Singleton
    fun providesApplication() = mApplication

    @Provides
    @Singleton
    fun providesContext(application: BiiApplication) = application.applicationContext
}

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(context: Context) = Room.databaseBuilder(context, BiiDatabase::class.java,
            BiiDatabase.NAME).build()
}