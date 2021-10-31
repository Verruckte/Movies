package com.project.movies.data.api

import com.project.movies.data.model.Movie

data class MovieResponse(
    val results: List<Movie>,
)