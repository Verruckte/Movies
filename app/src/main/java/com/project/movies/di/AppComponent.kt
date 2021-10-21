package com.project.movies.di

import com.project.movies.di.modules.*
import com.project.movies.mvp.presenter.DetailsPresenter
import com.project.movies.mvp.presenter.MainPresenter
import com.project.movies.mvp.presenter.MoviesPresenter
import com.project.movies.ui.activity.MainActivity
import com.project.movies.ui.adapter.MoviesRvAdapter
import com.project.movies.ui.fragment.DetailsFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AppModule::class,
    NavigationModule::class,
    ApiModule::class,
    ImageLoaderModule::class,
    MoviesScreenModule::class,
    DetailsScreenModule::class
])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(moviesPresenter: MoviesPresenter)
    fun inject(moviesRvAdapter: MoviesRvAdapter)
    fun inject(detailsFragment: DetailsFragment)
    fun inject(detailsPresenter: DetailsPresenter)
}