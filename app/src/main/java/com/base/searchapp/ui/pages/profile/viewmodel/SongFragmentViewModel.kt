package com.base.searchapp.ui.pages.profile.viewmodel

import com.base.core.ioc.scopes.FragmentScope
import com.base.searchapp.ui.base.viewmodel.BaseFragmentViewModel
import com.base.searchapp.ui.pages.profile.repository.SongFragmentRepository
import javax.inject.Inject

/**
 *   Created by Emre UYGUN on 12/5/20
 */

@FragmentScope
class SongFragmentViewModel @Inject constructor(
    private val repository: SongFragmentRepository
) : BaseFragmentViewModel() {

}