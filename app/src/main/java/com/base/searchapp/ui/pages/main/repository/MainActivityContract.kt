package com.base.searchapp.ui.pages.main.repository

import com.base.core.networking.DataFetchResult
import com.base.data.response.SearchListResponse
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject

/**
 *   Created by Emre UYGUN on 12/5/20
 */

interface MainActivityContract {

    interface Repository {
        fun <T> handleError(dataFetchResult: PublishSubject<DataFetchResult<T>>, error: Throwable)
        val searchListDataResult: PublishSubject<DataFetchResult<SearchListResponse>>
        fun getSearchList(term: String?, media: String?)
    }

    interface Remote {
        fun getSearchList(term: String?, media: String?): Single<SearchListResponse>
    }
}
