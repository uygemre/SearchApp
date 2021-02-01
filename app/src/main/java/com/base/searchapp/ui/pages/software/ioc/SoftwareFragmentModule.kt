package com.base.searchapp.ui.pages.software.ioc

import androidx.fragment.app.Fragment
import com.base.core.ioc.scopes.FragmentScope
import com.base.core.networking.Scheduler
import com.base.data.request.SearchApiInterface
import com.base.searchapp.ioc.keys.FragmentViewModelKey
import com.base.searchapp.ui.base.fragment.BaseViewModelFragmentModule
import com.base.searchapp.ui.base.viewmodel.BaseFragmentViewModel
import com.base.searchapp.ui.pages.software.SoftwareFragment
import com.base.searchapp.ui.pages.software.repository.SoftwareFragmentRemoteData
import com.base.searchapp.ui.pages.software.repository.SoftwareFragmentRepository
import com.base.searchapp.ui.pages.software.viewmodel.SoftwareFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.reactivex.disposables.CompositeDisposable

/**
 *   Created by Emre UYGUN on 12/5/20
 */

@Module(includes = [BaseViewModelFragmentModule::class])
abstract class SoftwareFragmentModule {

    @Binds
    @FragmentScope
    abstract fun bindFragment(fragment: SoftwareFragment): Fragment

    @Binds
    @IntoMap
    @FragmentViewModelKey(SoftwareFragmentViewModel::class)
    @FragmentScope
    abstract fun bindViewModel(viewModel: SoftwareFragmentViewModel): BaseFragmentViewModel

    @Module
    companion object {

        @Provides
        @FragmentScope
        @JvmStatic
        fun provideSoftwareRemoteData(apiInterface: SearchApiInterface) =
            SoftwareFragmentRemoteData(apiInterface)

        @Provides
        @FragmentScope
        @JvmStatic
        fun provideSoftwareRepository(
                remote: SoftwareFragmentRemoteData,
                scheduler: Scheduler,
                compositeDisposable: CompositeDisposable
        ) = SoftwareFragmentRepository(remote, scheduler, compositeDisposable)
    }
}