package com.timermakov.homeworkmtsteta.dto

import java.io.Serializable

data class MovieDto(
    val title: String,
    val description: String,
    val rateScore: Int,
    val ageRestriction: Int,
    val imageUrl: String
) : Serializable