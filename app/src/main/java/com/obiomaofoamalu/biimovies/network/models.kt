package com.obiomaofoamalu.biimovies.network

import com.google.gson.annotations.SerializedName
import com.obiomaofoamalu.biimovies.core.Country
import com.obiomaofoamalu.biimovies.core.Genre

//todo: kotlin doc
data class DiscoverMoviesResponse(
    val page: Int,
    @SerializedName("results") val movies: List<MovieResponse>
)


//todo: kotlin doc
data class MovieResponse(
    val id: Long,
    val title: String,
    @SerializedName("overview") val description: String,
    @SerializedName("vote_average") val rating: Double,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("genres") val genres: List<Genre>?,
    @SerializedName("production_countries") val countries: List<Country>?,
    @SerializedName("status") val status: String?,
    @SerializedName("runtime") val duration: Int?
)