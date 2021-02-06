package com.base.searchapp.ui.pages.movie.repository

import com.base.core.extensions.*
import com.base.core.ioc.scopes.FragmentScope
import com.base.core.networking.DataFetchResult
import com.base.core.networking.Scheduler
import com.base.data.response.MovieListResponse
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import timber.log.Timber

/**
 *   Created by Emre UYGUN on 12/5/20
 */

@FragmentScope
class MovieFragmentRepository(
    private val remote: MovieFragmentRemoteData,
    private val scheduler: Scheduler,
    private val compositeDisposable: CompositeDisposable
) : MovieFragmentContract.Repository {

    override val movieListDataResult = PublishSubject.create<DataFetchResult<MovieListResponse>>()

    override fun getMovieList(term: String?) {
        movieListDataResult.loading(true)
        remote.getMovieList(term)
            .performOnBackOutOnMain(scheduler)
            .subscribe(
                {
                    movieListDataResult.success(it)
                },
                { _error ->
                    handleError(movieListDataResult, _error)
                }
            ).addTo(compositeDisposable)
    }

    override fun <T> handleError(result: PublishSubject<DataFetchResult<T>>, error: Throwable) {
        result.failed(error)
        Timber.e(error.localizedMessage)
    }
}