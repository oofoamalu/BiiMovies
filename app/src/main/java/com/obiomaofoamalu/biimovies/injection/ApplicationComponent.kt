package com.obiomaofoamalu.biimovies.injection

import com.obiomaofoamalu.biimovies.launch.LaunchActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules=arrayOf(ApplicationModule::class, DatabaseModule::class))
interface ApplicationComponent {

    fun inject(activity: LaunchActivity)
}