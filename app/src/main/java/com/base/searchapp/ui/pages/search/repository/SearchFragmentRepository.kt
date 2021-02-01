package com.base.searchapp.ui.pages.search.repository

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
class SearchFragmentRepository(
    private val remote: SearchFragmentRemoteData,
    private val scheduler: Scheduler,
    private val compositeDisposable: CompositeDisposable
) : SearchFragmentContract.Repository {

    override fun <T> handleError(result: PublishSubject<DataFetchResult<T>>, error: Throwable) {
        result.failed(error)
        Timber.e(error.localizedMessage)
    }
}