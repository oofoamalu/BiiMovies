package com.obiomaofoamalu.biimovies.core

import java.util.*

//todo: kotlin docs
data class Movie(
    val id: Long,
    val rating: Double,
    val title: String,
    val description: String,
    val releaseDate: Date,
    val posterPath: String,
    val backdropPath: String,
    val genreIds: List<Int>
)


//todo: kotlin doc
data class Genre(
    val id: Long,
    val name: String
)


//todo: kotlin doc
data class Country(
    val name: String
)
