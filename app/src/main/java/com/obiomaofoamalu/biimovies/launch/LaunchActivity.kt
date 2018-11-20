package com.obiomaofoamalu.biimovies.launch

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.obiomaofoamalu.biimovies.R
import com.obiomaofoamalu.biimovies.databinding.ActivityLaunchBinding
import com.obiomaofoamalu.biimovies.injection.Injector
import com.obiomaofoamalu.biimovies.movielist.MovieList
import javax.inject.Inject

class LaunchActivity : AppCompatActivity() {

    //region INJECTED CLASSES ----------------------------------------------------------------------

    @Inject
    lateinit var mViewModel: LaunchViewModel

    //endregion

    //region CLASS VARIABLES -----------------------------------------------------------------------

    private lateinit var mBinding: ActivityLaunchBinding

    //endregion

    //region LIFECYCLE METHODS ---------------------------------------------------------------------

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_launch)
        Injector.applicationComponent.inject(this)

        initView()
    }

    override fun onResume() {
        super.onResume()
        mViewModel.getCountriesIfNecessary()
        mViewModel.getGenresIfNecessary()
    }

    //endregion

    //region PRIVATE CLASS METHODS -----------------------------------------------------------------

    private fun initView() {
        mBinding.browseMovies
                .setOnClickListener { MovieList.start(this)}
    }

    //endregion
}
