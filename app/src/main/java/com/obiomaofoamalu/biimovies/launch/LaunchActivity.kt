package com.obiomaofoamalu.biimovies.launch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.obiomaofoamalu.biimovies.R
import com.obiomaofoamalu.biimovies.injection.Injector
import javax.inject.Inject

class LaunchActivity : AppCompatActivity() {

    @Inject
    lateinit var mViewModel: LaunchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        Injector.applicationComponent.inject(this)
    }

    override fun onResume() {
        super.onResume()
        mViewModel.getCountriesIfNecessary()
        mViewModel.getGenresIfNecessary()
    }
}
