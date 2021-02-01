package com.base.searchapp.ui.pages.home

import android.os.Bundle
import android.view.View
import com.base.component.GoAwayRecyclerviewAdapter
import com.base.searchapp.R
import com.base.searchapp.ui.base.fragment.BaseViewModelFragment
import com.base.searchapp.ui.pages.home.viewmodel.HomeFragmentViewModel
import javax.inject.Inject

/**
 *   Created by Emre UYGUN on 12/5/20
 */

class HomeFragment : BaseViewModelFragment<HomeFragmentViewModel>() {

    @Inject
    lateinit var adapter: GoAwayRecyclerviewAdapter

    override val layoutViewRes: Int = R.layout.fragment_home

    override val viewModelClass: Class<HomeFragmentViewModel> =
        HomeFragmentViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //viewModel.getDataStorage()
    }
}