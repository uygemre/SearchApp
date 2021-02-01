package com.base.searchapp.ui.pages.search.viewmodel

import com.base.core.ioc.scopes.FragmentScope
import com.base.searchapp.ui.base.viewmodel.BaseFragmentViewModel
import com.base.searchapp.ui.pages.search.repository.SearchFragmentRepository
import javax.inject.Inject

/**
 *   Created by Emre UYGUN on 12/5/20
 */

@FragmentScope
class SearchFragmentViewModel @Inject constructor(
    var repository: SearchFragmentRepository
) : BaseFragmentViewModel() {

}