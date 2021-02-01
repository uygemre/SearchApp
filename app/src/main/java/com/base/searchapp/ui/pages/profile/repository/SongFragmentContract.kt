package com.base.searchapp.ui.pages.profile.repository

import com.base.core.networking.DataFetchResult
import io.reactivex.subjects.PublishSubject

/**
 *   Created by Emre UYGUN on 12/5/20
 */

interface SongFragmentContract {

    interface Repository {
        fun <T> handleError(dataFetchResult: PublishSubject<DataFetchResult<T>>, error: Throwable)
    }

    interface Remote {

    }

}