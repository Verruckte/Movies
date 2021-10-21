package com.project.movies.navigation

import com.project.movies.mvp.model.entity.Movie
import com.project.movies.ui.fragment.DetailsFragment
import com.project.movies.ui.fragment.MoviesFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen


class Screens {

    class MoviesScreen(): SupportAppScreen(){
        override fun getFragment() = MoviesFragment.newInstance()
    }

    class DetailsScreen(private val movie: Movie): SupportAppScreen(){
        override fun getFragment() = DetailsFragment.newInstance(movie)
    }

}