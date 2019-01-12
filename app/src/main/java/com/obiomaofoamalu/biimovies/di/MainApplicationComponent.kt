package com.obiomaofoamalu.biimovies.di

import com.obiomaofoamalu.biimovies.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * The [MainApplicationComponent] is a Dagger DI component.
 */
@Singleton
@Component(modules = [MainApplicationModule::class])
interface MainApplicationComponent {

    fun inject(activity: MainActivity)
}
