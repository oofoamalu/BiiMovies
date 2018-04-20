package com.obiomaofoamalu.biimovies.injection

import com.obiomaofoamalu.biimovies.BiiApplication

class Injector {

    companion object {
        lateinit var applicationComponent: ApplicationComponent

        fun createApplicationComponent(application: BiiApplication) {
            applicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(ApplicationModule(application))
                    .build()
        }
    }
}