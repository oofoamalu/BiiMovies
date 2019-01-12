package com.obiomaofoamalu.biimovies.di

import com.obiomaofoamalu.biimovies.BiiApplication
import com.obiomaofoamalu.biimovies.network.di.NetworkModule
import dagger.Module
import dagger.Provides

/**
 * The [MainApplicationModule] is used to provide app-wide dependencies.
 */
@Module(includes = [NetworkModule::class])
class MainApplicationModule(private val application: BiiApplication) {

    @Provides
    fun providesApplication() = application

    @Provides
    fun providesContext() = application.applicationContext
}
