package com.obiomaofoamalu.biimovies.launch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_launch.*
import com.obiomaofoamalu.biimovies.MainActivity
import com.obiomaofoamalu.biimovies.R


/**
 * The [LaunchActivity] is the entry point of the application.
 */
class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        browseMoviesButton.setOnClickListener {
            MainActivity.startActivity(this)
        }
    }
}
