package com.base.searchapp.ui.pages.search

import android.os.Bundle
import android.view.View
import com.base.searchapp.R
import com.base.searchapp.ui.base.fragment.BaseViewModelFragment
import com.base.searchapp.ui.pages.search.viewmodel.SearchFragmentViewModel

/**
 *   Created by Emre UYGUN on 12/5/20
 */

class SearchFragment : BaseViewModelFragment<SearchFragmentViewModel>() {

    override val viewModelClass = SearchFragmentViewModel::class.java
    override val layoutViewRes = R.layout.fragment_search

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}