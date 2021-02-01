package com.base.searchapp.ui.pages.profile.ioc

import androidx.fragment.app.Fragment
import com.base.core.ioc.scopes.FragmentScope
import com.base.core.networking.Scheduler
import com.base.data.request.SearchApiInterface
import com.base.searchapp.ioc.keys.FragmentViewModelKey
import com.base.searchapp.ui.base.fragment.BaseViewModelFragmentModule
import com.base.searchapp.ui.base.viewmodel.BaseFragmentViewModel
import com.base.searchapp.ui.pages.profile.ProfileFragment
import com.base.searchapp.ui.pages.profile.repository.ProfileFragmentRemoteData
import com.base.searchapp.ui.pages.profile.repository.ProfileFragmentRepository
import com.base.searchapp.ui.pages.profile.viewmodel.ProfileFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.reactivex.disposables.CompositeDisposable

/**
 *   Created by Emre UYGUN on 12/5/20
 */

@Module(includes = [BaseViewModelFragmentModule::class])
abstract class ProfileFragmentModule {

    @Binds
    @FragmentScope
    abstract fun bindFragment(fragment: ProfileFragment): Fragment

    @Binds
    @IntoMap
    @FragmentViewModelKey(ProfileFragmentViewModel::class)
    @FragmentScope
    abstract fun bindViewModel(viewModel: ProfileFragmentViewModel): BaseFragmentViewModel

    @Module
    companion object {

        @Provides
        @FragmentScope
        @JvmStatic
        fun provideProfileRemoteData(apiInterface: SearchApiInterface) =
            ProfileFragmentRemoteData(apiInterface)

        @Provides
        @FragmentScope
        @JvmStatic
        fun provideProfileRepository(
            remote: ProfileFragmentRemoteData,
            scheduler: Scheduler,
            compositeDisposable: CompositeDisposable
        ) = ProfileFragmentRepository(remote, scheduler, compositeDisposable)
    }
}