package com.project.movies.mvp.model.repository

import com.project.movies.mvp.model.entity.Movie
import io.reactivex.rxjava3.core.Single

interface IMoviesRepository {
    fun getMovies(page: Int): Single<List<Movie>>
}