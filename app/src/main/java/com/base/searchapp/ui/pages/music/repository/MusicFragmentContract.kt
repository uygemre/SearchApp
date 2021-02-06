package com.base.searchapp.ui.pages.music.repository

import com.base.core.networking.DataFetchResult
import com.base.data.response.MusicListResponse
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject

/**
 *   Created by Emre UYGUN on 12/5/20
 */

interface MusicFragmentContract {

    interface Repository {
        fun <T> handleError(dataFetchResult: PublishSubject<DataFetchResult<T>>, error: Throwable)
        val musicListDataResult: PublishSubject<DataFetchResult<MusicListResponse>>
        fun getMusicList(term: String?)
    }

    interface Remote {
        fun getMusicList(term: String?): Single<MusicListResponse>
    }

}