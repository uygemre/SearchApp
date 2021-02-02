package com.base.searchapp.ui.pages.music.repository

import com.base.core.extensions.*
import com.base.core.networking.DataFetchResult
import com.base.core.networking.Scheduler
import com.base.data.response.MusicListResponse
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import timber.log.Timber

/**
 *   Created by Emre UYGUN on 12/5/20
 */

class MusicFragmentRepository(
    private val remote: MusicFragmentRemoteData,
    private val scheduler: Scheduler,
    private val compositeDisposable: CompositeDisposable
) : MusicFragmentContract.Repository {

    override fun <T> handleError(result: PublishSubject<DataFetchResult<T>>, error: Throwable) {
        result.failed(error)
        Timber.e(error.localizedMessage)
    }

    override val musicListDataResult = PublishSubject.create<DataFetchResult<MusicListResponse>>()

    override fun getMusicList() {
        musicListDataResult.loading(true)
        remote.getMusicList()
            .performOnBackOutOnMain(scheduler)
            .subscribe(
                {
                    musicListDataResult.success(it)
                },
                { _error ->
                    handleError(musicListDataResult, _error)
                }
            ).addTo(compositeDisposable)
    }
}