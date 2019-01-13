package com.obiomaofoamalu.biimovies.di

import com.obiomaofoamalu.biimovies.BiiApplication
import dagger.Module

/**
 * The [MainApplicationModule] is used to provide app wide dependencies.
 */
@Module
class MainApplicationModule(private val application: BiiApplication)