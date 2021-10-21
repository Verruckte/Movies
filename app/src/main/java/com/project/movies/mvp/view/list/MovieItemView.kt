package com.project.movies.mvp.view.list

interface MovieItemView: IItemView {
    fun setTitle(title: String)
    fun loadImage(imageUrl: String)
}