package com.timermakov.homeworkmtsteta.movies

import com.timermakov.homeworkmtsteta.dto.MovieDto

interface MoviesDataSource {
    fun getMovies(): List<MovieDto>
}