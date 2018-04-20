package com.obiomaofoamalu.biimovies

import android.app.Application
import com.obiomaofoamalu.biimovies.injection.Injector

class BiiApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.createApplicationComponent(this)
    }
}