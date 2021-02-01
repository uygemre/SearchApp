package com.base.searchapp.ui.pages.search.repository

import com.base.data.request.SearchApiInterface

/**
 *   Created by Emre UYGUN on 12/5/20
 */

class SearchFragmentRemoteData(
    private val apiInterface: SearchApiInterface
) :
    SearchFragmentContract.Remote {

}