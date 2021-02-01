package com.base.searchapp.ui.pages.software

import android.os.Bundle
import android.view.View
import com.base.searchapp.R
import com.base.searchapp.ui.base.fragment.BaseViewModelFragment
import com.base.searchapp.ui.pages.software.viewmodel.SoftwareFragmentViewModel

/**
 *   Created by Emre UYGUN on 12/5/20
 */

class SoftwareFragment : BaseViewModelFragment<SoftwareFragmentViewModel>() {

    override val viewModelClass = SoftwareFragmentViewModel::class.java
    override val layoutViewRes = R.layout.fragment_software

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}