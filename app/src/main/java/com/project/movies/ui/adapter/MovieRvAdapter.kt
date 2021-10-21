package com.project.movies.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.project.movies.R
import com.project.movies.mvp.model.imageloader.IImageLoader
import com.project.movies.mvp.presenter.list.IMoviesListPresenter
import com.project.movies.mvp.view.list.MovieItemView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_movie.view.*
import javax.inject.Inject

class MoviesRvAdapter (val presenter: IMoviesListPresenter) : RecyclerView.Adapter<MoviesRvAdapter.ViewHolder>() {

    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)).apply {
            println("Adapter: onCreateViewHolder")
            containerView.setOnClickListener {
                presenter.itemClickListener?.invoke(this)
            }
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        println("Adapter: onBindViewHolder")
        holder.pos = position
        holder.containerView.setOnClickListener { presenter.itemClickListener?.invoke(holder) }
        presenter.bindView(holder)
    }

    override fun getItemCount() = presenter.getCount()

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        MovieItemView,
        LayoutContainer {
        val imgContainer = containerView.findViewById<ImageView>(R.id.iv_image)
        override var pos = -1

        override fun setTitle(title: String) = with(containerView){
            tv_title.text = title
        }

        override fun loadImage(imageUrl: String) {
            imageLoader.loadInto(imageUrl, imgContainer)
        }
    }

}