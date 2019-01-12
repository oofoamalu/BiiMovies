package com.obiomaofoamalu.biimovies

import android.app.Application
import com.obiomaofoamalu.biimovies.di.Injector

/**
 *  The [BiiApplication] is the custom [Application] class for this project.
 *  It initializes the Dagger application component.
 */
class BiiApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.createApplicationComponent(this)
    }
}
