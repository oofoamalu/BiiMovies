package com.obiomaofoamalu.biimovies.di

import com.obiomaofoamalu.biimovies.BiiApplication

/**
 * The [Injector] initializes the [MainApplicationComponent] and
 * provides a convenient method for injection.
 */
class Injector {

    companion object {
        lateinit var applicationComponent: MainApplicationComponent

        /**
         * Initializes the [MainApplicationComponent].
         */
        fun createApplicationComponent(application: BiiApplication) {
            applicationComponent = DaggerMainApplicationComponent.builder()
                .mainApplicationModule(MainApplicationModule(application))
                .build()
        }
    }
}
