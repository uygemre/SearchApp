package com.base.searchapp.ui.pages.profile

import android.os.Bundle
import android.view.View
import com.base.searchapp.R
import com.base.searchapp.ui.base.fragment.BaseViewModelFragment
import com.base.searchapp.ui.pages.profile.viewmodel.ProfileFragmentViewModel

/**
 *   Created by Emre UYGUN on 12/5/20
 */

class ProfileFragment : BaseViewModelFragment<ProfileFragmentViewModel>() {

    override val viewModelClass = ProfileFragmentViewModel::class.java

    override val layoutViewRes = R.layout.fragment_profile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}