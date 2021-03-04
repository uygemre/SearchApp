package com.base.searchapp.ui.pages.detail.repository

import com.base.core.networking.Scheduler
import io.reactivex.disposables.CompositeDisposable

// Created by Emre UYGUN on 2/14/21
// Copyriht © Demiroren Technology. All rights reserved.

class DetailActivityRepository(
    private val remote: DetailActivityRemoteData,
    private val scheduler: Scheduler,
    private val compositeDisposable: CompositeDisposable
) : DetailActivityContract.Repository {
}