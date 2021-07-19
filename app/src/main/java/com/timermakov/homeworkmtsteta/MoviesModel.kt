package com.timermakov.homeworkmtsteta

import com.timermakov.homeworkmtsteta.movies.MoviesDataSource

class MoviesModel(private val moviesDataSource: MoviesDataSource) {
    fun getMovies() = moviesDataSource.getMovies()
}