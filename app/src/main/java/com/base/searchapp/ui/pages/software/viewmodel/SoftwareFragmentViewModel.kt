package com.base.searchapp.ui.pages.software.viewmodel

import com.base.core.ioc.scopes.FragmentScope
import com.base.searchapp.ui.base.viewmodel.BaseFragmentViewModel
import com.base.searchapp.ui.pages.software.repository.SoftwareFragmentRepository
import javax.inject.Inject

/**
 *   Created by Emre UYGUN on 12/5/20
 */

@FragmentScope
class SoftwareFragmentViewModel @Inject constructor(
    var repository: SoftwareFragmentRepository
) : BaseFragmentViewModel() {

}