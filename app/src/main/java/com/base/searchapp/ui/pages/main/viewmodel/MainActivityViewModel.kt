package com.base.searchapp.ui.pages.main.viewmodel

import com.base.core.ioc.scopes.ActivityScope
import com.base.searchapp.ui.base.viewmodel.BaseActivityViewModel
import com.base.searchapp.ui.pages.main.repository.MainActivityRepository
import javax.inject.Inject

/**
 *   Created by Emre UYGUN on 12/5/20
 */

@ActivityScope
class MainActivityViewModel @Inject constructor(
    private val repository: MainActivityRepository
) : BaseActivityViewModel() {

}