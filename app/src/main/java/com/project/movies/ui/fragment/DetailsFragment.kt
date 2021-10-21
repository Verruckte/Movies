package com.project.movies.ui.fragment

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.project.movies.R
import com.project.movies.mvp.model.entity.Movie
import com.project.movies.mvp.model.imageloader.IImageLoader
import com.project.movies.mvp.presenter.DetailsPresenter
import com.project.movies.mvp.view.DetailsView
import com.project.movies.ui.App
import com.project.movies.ui.BackButtonListener
import kotlinx.android.synthetic.main.fragment_details.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject


class DetailsFragment: MvpAppCompatFragment(), DetailsView, BackButtonListener {


    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>

    companion object {
        fun newInstance(movie: Movie) = DetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable("movie", movie)
            }
        }
    }


    val presenter: DetailsPresenter by moxyPresenter {
        val movie = arguments?.getParcelable<Movie>("movie") as Movie
        DetailsPresenter(movie).apply { App.instance.appComponent.inject(this) }
    }

    constructor(parcel: Parcel) : this() {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        View.inflate(context, R.layout.fragment_details, null)

    override fun init() {
        App.instance.appComponent.inject(this)
    }

    override fun setTitle (title: String) { tv_name.text = title }
    override fun setAbout(overview: String) { tv_about.text = overview }
    override fun loadImage(posterPath: String) = imageLoader.loadWithRoundCornersInto(posterPath, iv_image)
    override fun loadBackdropImage(backdropPath: String?) {
        imageLoader.loadInto(backdropPath, iv_backdrop)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DetailsFragment> {
        override fun createFromParcel(parcel: Parcel): DetailsFragment {
            return DetailsFragment(parcel)
        }

        override fun newArray(size: Int): Array<DetailsFragment?> {
            return arrayOfNulls(size)
        }
    }

    override fun backPressed() = presenter.backClick()

}