package com.obiomaofoamalu.biimovies.injection

import android.app.LauncherActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules=arrayOf(ApplicationModule::class, DatabaseModule::class))
interface ApplicationComponent {

    fun inject(activity: LauncherActivity)
}