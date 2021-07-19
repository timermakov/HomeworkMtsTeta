package com.timermakov.homeworkmtsteta.movies

class MoviesModel(private val moviesDataSource: MoviesDataSource) {
    fun getMovies() = moviesDataSource.getMovies()
}