package com.obiomaofoamalu.biimovies.launch

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.obiomaofoamalu.biimovies.R
import com.obiomaofoamalu.biimovies.databinding.ActivityLaunchBinding
import com.obiomaofoamalu.biimovies.injection.Injector
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

    //region LISTENERS -----------------------------------------------------------------------------

    private class BrowseMoviesClickListener : View.OnClickListener {
        override fun onClick(view: View) {
            //todo: open movie list
        }
    }

    //endregion

    //region PRIVATE CLASS METHODS -----------------------------------------------------------------

    private fun initView() {
        mBinding.browseMovies
                .setOnClickListener(BrowseMoviesClickListener())
    }

    //endregion
}
