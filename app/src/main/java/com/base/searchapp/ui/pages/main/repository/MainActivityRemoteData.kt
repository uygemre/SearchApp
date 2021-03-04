package com.base.searchapp.ui.pages.main.repository

import com.base.data.request.SearchApiInterface
import com.base.data.response.SearchListResponse
import io.reactivex.Single

/**
 *   Created by Emre UYGUN on 12/5/20
 */

class MainActivityRemoteData(private val apiInterface: SearchApiInterface) :
    MainActivityContract.Remote {

    override fun getSearchList(term: String?, media: String?): Single<SearchListResponse> =
        apiInterface.getSearchList(term, media)

}
