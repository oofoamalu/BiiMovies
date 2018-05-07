package com.obiomaofoamalu.biimovies.service

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BiiService {

    @GET("genre/movie/list")
    fun getGenres(@Query("api_key") key: String): Observable<GenreResponse>

    @GET("configuration/countries")
    fun getCountries(@Query("api_key") key: String): Observable<ArrayList<CountryResponse>>

    @GET("discover/movie")
    fun getMovies(@Query("api_key") key: String): Observable<DiscoverMovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") movieId: Int,
                        @Query("api_key") key: String): Observable<MovieDetailResponse>

}