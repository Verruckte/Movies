package com.project.movies.di.modules

import com.project.movies.mvp.model.api.IDataSource
import com.project.movies.mvp.model.repository.IMoviesRepository
import com.project.movies.mvp.model.repository.retrofit.RetrofitMoviesRepository
import dagger.Module
import dagger.Provides

@Module
class MoviesScreenModule {

    @Provides
    fun moviesRepository(api: IDataSource): IMoviesRepository =
        RetrofitMoviesRepository(api)

}