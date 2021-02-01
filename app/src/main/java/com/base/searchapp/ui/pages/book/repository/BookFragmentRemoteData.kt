package com.base.searchapp.ui.pages.book.repository

import com.base.data.request.SearchApiInterface

/**
 *   Created by Emre UYGUN on 2/1/21
 */

class BookFragmentRemoteData(
        private val apiInterface: SearchApiInterface
) : BookFragmentContract.Remote {
}