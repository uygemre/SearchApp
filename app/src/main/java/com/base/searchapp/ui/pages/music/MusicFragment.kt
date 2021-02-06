package com.base.searchapp.ui.pages.music

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.base.component.SearchAppRecyclerviewAdapter
import com.base.core.extensions.setup
import com.base.core.networking.DataFetchResult
import com.base.searchapp.R
import com.base.searchapp.ui.base.fragment.BaseViewModelFragment
import com.base.searchapp.ui.pages.music.viewmodel.MusicFragmentViewModel
import kotlinx.android.synthetic.main.fragment_music.*
import javax.inject.Inject

/**
 *   Created by Emre UYGUN on 12/5/20
 */

class MusicFragment : BaseViewModelFragment<MusicFragmentViewModel>() {

    override val viewModelClass = MusicFragmentViewModel::class.java
    override val layoutViewRes = R.layout.fragment_music

    @Inject
    lateinit var adapter: SearchAppRecyclerviewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_music.setup(adapter = adapter.getAdapter())
        bindObserver()

    }

    @SuppressLint("CheckResult")
    private fun bindObserver() {
        viewModel.getMusicList("metallica")
        viewModel.musicListPublishSubject.subscribe {
            adapter.getAdapter().updateAllItems(it)
        }

        viewModel.musicListDataResult.observe(viewLifecycleOwner, Observer {
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