package com.project.movies.mvp.view

import com.project.movies.mvp.model.entity.Movie
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

@AddToEndSingle
interface MoviesView: MvpView {
    fun init()
    fun updateMoviesList()
    fun scrollListToCurrentPosition(currentItem: Int)

    @Skip
    fun openDetailsFragment(movie: Movie)
}