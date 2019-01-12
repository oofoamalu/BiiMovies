package com.obiomaofoamalu.biimovies.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val BASE_URL = "https://api.themoviedb.org/3/"


//todo: kotlin doc
interface MovieApi {

    @GET("discover/movie")
    fun getDiscoverMovies(@Query("api_key") key: String): Observable<DiscoverMoviesResponse>
}


//todo: kotlin doc
class BiiApiFactory {

    companion object {

        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        fun createMovieApi(): MovieApi = retrofit.create(MovieApi::class.java)
    }
}
