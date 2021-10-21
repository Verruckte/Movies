package com.project.movies.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface DetailsView: MvpView {
    fun init()
    fun setTitle(title: String)
    fun setAbout(overview: String)
    fun loadImage(posterPath: String)
    fun loadBackdropImage(backdropPath: String?)

}