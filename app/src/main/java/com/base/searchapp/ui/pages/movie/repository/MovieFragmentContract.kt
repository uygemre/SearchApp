package com.base.searchapp.ui.pages.movie.repository

import com.base.core.networking.DataFetchResult
import com.base.data.response.MovieListResponse
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject

/**
 *   Created by Emre UYGUN on 12/5/20
 */

interface MovieFragmentContract {

    interface Repository {
        fun <T> handleError(dataFetchResult: PublishSubject<DataFetchResult<T>>, error: Throwable)
        val movieListDataResult: PublishSubject<DataFetchResult<MovieListResponse>>
        fun getMovieList(term: String?)
    }
    interface Remote{
        fun getMovieList(term: String?): Single<MovieListResponse>
    }

}