package com.obiomaofoamalu.biimovies.service

import android.content.res.Resources
import com.obiomaofoamalu.biimovies.R
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class TestServiceInfoProvider {

    @Mock private lateinit var mResources: Resources

    private lateinit var mServiceInfoProvider: ServiceInfoProvider

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        mServiceInfoProvider = ServiceInfoProvider(mResources)
    }

    @Test
    fun getBaseURl() {
        // GIVEN that base url is stored in string resource
        Mockito.`when`(mResources.getString(R.string.base_url)).thenReturn("www.mockurl.com")

        // WHEN we call getBaseUrl()
        val result = mServiceInfoProvider.getBaseUrl()

        // THEN verify that url was retrieved from string resource
        verify(mResources).getString(R.string.base_url)
        // THEN assert that result is a web url
        assertTrue(result.matches("""www\.(.)+\.[a-z]+""".toRegex()))
    }

    @Test
    fun getApiKey() {
        // GIVEN that api key is stored in string resource
        Mockito.`when`(mResources.getString(R.string.api_key)).thenReturn("mockapikey392844")

        // WHEN we call getApiKey()
        val result = mServiceInfoProvider.getApiKey()

        // THEN verify that api key was retrieved from string resource
        verify(mResources).getString(R.string.api_key)
    }
}
