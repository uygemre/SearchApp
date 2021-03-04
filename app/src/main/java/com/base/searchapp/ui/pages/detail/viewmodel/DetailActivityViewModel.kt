package com.base.searchapp.ui.pages.detail.viewmodel

import com.base.searchapp.ui.base.viewmodel.BaseActivityViewModel
import com.base.searchapp.ui.pages.detail.repository.DetailActivityRepository
import javax.inject.Inject

// Created by Emre UYGUN on 2/14/21
// Copyriht © Demiroren Technology. All rights reserved.

class DetailActivityViewModel @Inject constructor(
    private val repository: DetailActivityRepository
) : BaseActivityViewModel() {
}