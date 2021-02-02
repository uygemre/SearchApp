package com.base.searchapp.ui.pages.movie

import android.os.Bundle
import android.view.View
import com.base.component.SearchAppRecyclerviewAdapter
import com.base.searchapp.R
import com.base.searchapp.ui.base.fragment.BaseViewModelFragment
import com.base.searchapp.ui.pages.movie.viewmodel.MovieFragmentViewModel
import javax.inject.Inject

/**
 *   Created by Emre UYGUN on 12/5/20
 */

class MovieFragment : BaseViewModelFragment<MovieFragmentViewModel>() {

    @Inject
    lateinit var adapter: SearchAppRecyclerviewAdapter

    override val layoutViewRes: Int = R.layout.fragment_movie

    override val viewModelClass: Class<MovieFragmentViewModel> =
        MovieFragmentViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //viewModel.getDataStorage()
    }
}