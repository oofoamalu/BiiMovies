package com.obiomaofoamalu.biimovies.service

import com.google.gson.annotations.SerializedName
import com.obiomaofoamalu.biimovies.database.Genre

data class MovieResponse (val id: Int,
                          val title: String,
                         @SerializedName("overview") val description: String,
                         @SerializedName("vote_average") val rating: Double,
                         @SerializedName("poster_path") val posterPath: String,
                         @SerializedName("backdrop_path") val backdropPath: String,
                         @SerializedName("release_date") val releaseDate: String,
                         @SerializedName("genre_ids") val genreIds: ArrayList<Int>)

data class DiscoverMovieResponse(
        @SerializedName("results") val movies: ArrayList<MovieResponse>)

data class MovieDetailResponse(@SerializedName("runtime") val duration: Int,
                               @SerializedName("production_countries") val countries: ArrayList<CountryResponse>)

data class GenreResponse(@SerializedName("genres") val genres: ArrayList<Genre>)

data class CountryResponse(@SerializedName("iso_3166_1") val id: String,
                           @SerializedName("english_name") val name: String)

