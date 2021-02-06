package com.base.searchapp.ui.pages.music.repository

import com.base.data.request.SearchApiInterface
import com.base.data.response.MusicListResponse
import io.reactivex.Single

/**
 *   Created by Emre UYGUN on 12/5/20
 */

class MusicFragmentRemoteData(
    private val apiInterface: SearchApiInterface
) : MusicFragmentContract.Remote {

    override fun getMusicList(term: String?): Single<MusicListResponse> = apiInterface.getMusicList(term)

}