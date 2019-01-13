package com.obiomaofoamalu.biimovies

import android.app.Application
import com.obiomaofoamalu.biimovies.di.Injector

/**
 * The [BiiApplication] class is a custom implementation of [Application].
 * It initializes the Dagger component.
 */
class BiiApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.createApplicationComponent(this)
    }
}
