package com.base.searchapp.ui.pages.main.repository

import com.base.core.extensions.*
import com.base.core.networking.DataFetchResult
import com.base.core.networking.Scheduler
import com.base.data.response.SearchListResponse
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import timber.log.Timber

/**
 *   Created by Emre UYGUN on 12/5/20
 */

class MainActivityRepository(
    private val remote: MainActivityRemoteData,
    private val scheduler: Scheduler,
    private val compositeDisposable: CompositeDisposable
) : MainActivityContract.Repository {

    override fun <T> handleError(
        dataFetchResult: PublishSubject<DataFetchResult<T>>,
        error: Throwable
    ) {
        dataFetchResult.failed(error)
        Timber.e(error.localizedMessage)
    }

    override val searchListDataResult = PublishSubject.create<DataFetchResult<SearchListResponse>>()

    override fun getSearchList(term: String?, media: String?) {
        searchListDataResult.loading(true)
        remote.getSearchList(term, media)
            .performOnBackOutOnMain(scheduler)
            .subscribe(
                {
                    searchListDataResult.success(it)
                },
                { _error ->
                    handleError(searchListDataResult, _error)
                }
            ).addTo(compositeDisposable)
    }
}
