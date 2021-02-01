package com.base.searchapp.ui.pages.home.repository

import com.base.data.request.SearchApiInterface

/**
 *   Created by Emre UYGUN on 12/5/20
 */

class HomeFragmentRemoteData(
    private val apiInterface: SearchApiInterface
) :
    HomeFragmentContract.Remote {

}