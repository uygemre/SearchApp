package com.base.searchapp.ui.pages.movie.repository

import com.base.data.request.SearchApiInterface

/**
 *   Created by Emre UYGUN on 12/5/20
 */

class MovieFragmentRemoteData(
        private val apiInterface: SearchApiInterface
) : MovieFragmentContract.Remote {

}