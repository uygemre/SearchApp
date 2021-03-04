package com.base.searchapp.ui.pages.detail

import android.os.Bundle
import com.base.data.response.SearchResults
import com.base.searchapp.R
import com.base.searchapp.ui.base.activity.BaseActivity
import com.base.searchapp.ui.pages.detail.viewmodel.DetailActivityViewModel
import kotlinx.android.synthetic.main.layout_toolbar.*

// Created by Emre UYGUN on 2/14/21
// Copyriht © Demiroren Technology. All rights reserved.

class DetailActivity : BaseActivity<DetailActivityViewModel>() {

    override val viewModelClass = DetailActivityViewModel::class.java
    override var layoutViewRes = R.layout.activity_detail

    private var item: SearchResults? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = intent.getParcelableExtra("item")

        setupView()
    }

    private fun setupView() {
        tv_title.text = item?.trackName
        btn_back.setOnClickListener {
            onBackPressed()
        }
    }
}