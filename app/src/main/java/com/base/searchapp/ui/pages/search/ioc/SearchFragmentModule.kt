package com.base.searchapp.ui.pages.search.ioc

import androidx.fragment.app.Fragment
import com.base.core.ioc.scopes.FragmentScope
import com.base.core.networking.Scheduler
import com.base.data.request.SearchApiInterface
import com.base.searchapp.ioc.keys.FragmentViewModelKey
import com.base.searchapp.ui.base.fragment.BaseViewModelFragmentModule
import com.base.searchapp.ui.base.viewmodel.BaseFragmentViewModel
import com.base.searchapp.ui.pages.search.SearchFragment
import com.base.searchapp.ui.pages.search.repository.SearchFragmentRemoteData
import com.base.searchapp.ui.pages.search.repository.SearchFragmentRepository
import com.base.searchapp.ui.pages.search.viewmodel.SearchFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.reactivex.disposables.CompositeDisposable

/**
 *   Created by Emre UYGUN on 12/5/20
 */

@Module(includes = [BaseViewModelFragmentModule::class])
abstract class SearchFragmentModule {

    @Binds
    @FragmentScope
    abstract fun bindFragment(fragment: SearchFragment): Fragment

    @Binds
    @IntoMap
    @FragmentViewModelKey(SearchFragmentViewModel::class)
    @FragmentScope
    abstract fun bindViewModel(viewModel: SearchFragmentViewModel): BaseFragmentViewModel

    @Module
    companion object {

        @Provides
        @FragmentScope
        @JvmStatic
        fun provideSearchRemoteData(apiInterface: SearchApiInterface) =
            SearchFragmentRemoteData(apiInterface)

        @Provides
        @FragmentScope
        @JvmStatic
        fun provideSearchRepository(
            remote: SearchFragmentRemoteData,
            scheduler: Scheduler,
            compositeDisposable: CompositeDisposable
        ) = SearchFragmentRepository(remote, scheduler, compositeDisposable)
    }
}