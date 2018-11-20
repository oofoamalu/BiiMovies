package com.obiomaofoamalu.biimovies.launch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.obiomaofoamalu.biimovies.R
import kotlinx.android.synthetic.main.activity_launch.*

/**
 * The [LaunchActivity] is the entry point of the application.
 */
class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        browseMoviesButton.setOnClickListener {
            Toast.makeText(this, "Implement me.", Toast.LENGTH_LONG).show()
        }
    }
}
