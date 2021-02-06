package com.base.searchapp.ui.pages.movie

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.base.component.SearchAppRecyclerviewAdapter
import com.base.core.extensions.setup
import com.base.core.networking.DataFetchResult
import com.base.searchapp.R
import com.base.searchapp.ui.base.fragment.BaseViewModelFragment
import com.base.searchapp.ui.pages.movie.viewmodel.MovieFragmentViewModel
import kotlinx.android.synthetic.main.fragment_movie.*
import javax.inject.Inject

/**
 *   Created by Emre UYGUN on 12/5/20
 */

class MovieFragment : BaseViewModelFragment<MovieFragmentViewModel>() {

    override val viewModelClass = MovieFragmentViewModel::class.java
    override val layoutViewRes = R.layout.fragment_movie

    @Inject
    lateinit var adapter: SearchAppRecyclerviewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindObserver()
        rv_movie.setup(adapter = adapter.getAdapter())

    }

    @SuppressLint("CheckResult")
    private fun bindObserver() {
        viewModel.getMovieList("godfather")
        viewModel.movieListPublishSubject.subscribe {
            adapter.getAdapter().updateAllItems(it)
        }

        viewModel.movieListDataResult.observe(viewLifecycleOwner, Observer {
            when (it) {
                is DataFetchResult.Progress -> {
                }
                is DataFetchResult.Failure -> {
                }
                is DataFetchResult.Success -> {
                }
            }
        })
    }
}