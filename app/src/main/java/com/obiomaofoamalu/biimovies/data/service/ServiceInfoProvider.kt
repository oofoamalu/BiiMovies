package com.obiomaofoamalu.biimovies.data.service

import android.content.res.Resources
import com.obiomaofoamalu.biimovies.R
import javax.inject.Inject

class ServiceInfoProvider @Inject constructor (private val mResources: Resources) {

    fun getBaseUrl() = mResources.getString(R.string.base_url)

    fun getApiKey() = mResources.getString(R.string.api_key)
}