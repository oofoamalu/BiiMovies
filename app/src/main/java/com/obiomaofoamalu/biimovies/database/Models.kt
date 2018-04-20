package com.obiomaofoamalu.biimovies.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Movies", indices = arrayOf(Index(value = "id", unique = true)))
data class Movie(@PrimaryKey val id: Int, val title: String, val description: String,
                 val posterUrl: String, val duration: Int, val releaseYear: String,
                 val rating: Double, val backdropUrl: String, val genreIds: ArrayList<Int>,
                 val countryIds: ArrayList<String>)

@Entity(tableName = "Genres", indices = arrayOf(Index(value = "id", unique = true)))
data class Genre(@PrimaryKey val id: Int, val name: String)

@Entity(tableName = "Countries", indices = arrayOf(Index(value = "id", unique = true)))
data class Country(@PrimaryKey val id: String, val name: String)