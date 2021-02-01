package com.base.searchapp.ui.pages.book.repository

import com.base.core.ioc.scopes.FragmentScope
import com.base.core.networking.Scheduler
import io.reactivex.disposables.CompositeDisposable

/**
 *   Created by Emre UYGUN on 2/1/21
 */

@FragmentScope
class BookFragmentRepository(
        private val remote: BookFragmentRemoteData,
        private val scheduler: Scheduler,
        private val compositeDisposable: CompositeDisposable
) : BookFragmentContract.Repository {

}