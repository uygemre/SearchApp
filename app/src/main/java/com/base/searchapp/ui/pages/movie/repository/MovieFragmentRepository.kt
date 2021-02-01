package com.base.searchapp.ui.pages.movie.repository

import com.base.core.extensions.failed
import com.base.core.ioc.scopes.FragmentScope
import com.base.core.networking.DataFetchResult
import com.base.core.networking.Scheduler
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

    override fun <T> handleError(result: PublishSubject<DataFetchResult<T>>, error: Throwable) {
        result.failed(error)
        Timber.e(error.localizedMessage)
    }
}