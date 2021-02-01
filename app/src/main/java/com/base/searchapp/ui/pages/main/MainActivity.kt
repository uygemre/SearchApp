package com.base.searchapp.ui.pages.main

import android.os.Bundle
import com.base.core.helpers.LocalPrefManager
import com.base.searchapp.R
import com.base.searchapp.ui.base.activity.BaseActivity
import com.base.searchapp.ui.pages.main.viewmodel.MainActivityViewModel
import javax.inject.Inject

/**
 *   Created by Emre UYGUN on 12/5/20
 */

class MainActivity : BaseActivity<MainActivityViewModel>() {

    override val viewModelClass = MainActivityViewModel::class.java
    override val layoutViewRes = R.layout.activity_main

    @Inject
    lateinit var localPrefManager: LocalPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
    }

}
