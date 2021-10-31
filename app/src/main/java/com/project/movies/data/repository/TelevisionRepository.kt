package com.project.movies.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.rxjava3.flowable
import com.project.movies.data.api.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TelevisionRepository @Inject constructor(
    private val apiService: ApiService,
) {

    fun getTvPopular() =
        Pager(
            config = PagingConfig(
                pageSize = 5,
                maxSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { TelevisionPagingSource(apiService, null) }
        ).flowable

    fun searchTv(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 5,
                maxSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { TelevisionPagingSource(apiService, query) }
        ).flowable

}