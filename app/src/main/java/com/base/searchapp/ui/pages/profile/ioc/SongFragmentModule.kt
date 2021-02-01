package com.base.searchapp.ui.pages.profile.ioc

import androidx.fragment.app.Fragment
import com.base.core.ioc.scopes.FragmentScope
import com.base.core.networking.Scheduler
import com.base.data.request.SearchApiInterface
import com.base.searchapp.ioc.keys.FragmentViewModelKey
import com.base.searchapp.ui.base.fragment.BaseViewModelFragmentModule
import com.base.searchapp.ui.base.viewmodel.BaseFragmentViewModel
import com.base.searchapp.ui.pages.profile.repository.SongFragmentRemoteData
import com.base.searchapp.ui.pages.profile.repository.SongFragmentRepository
import com.base.searchapp.ui.pages.profile.viewmodel.SongFragmentViewModel
import com.base.searchapp.ui.pages.song.SongFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.reactivex.disposables.CompositeDisposable

/**
 *   Created by Emre UYGUN on 12/5/20
 */

@Module(includes = [BaseViewModelFragmentModule::class])
abstract class SongFragmentModule {

    @Binds
    @FragmentScope
    abstract fun bindFragment(fragment: SongFragment): Fragment

    @Binds
    @IntoMap
    @FragmentViewModelKey(SongFragmentViewModel::class)
    @FragmentScope
    abstract fun bindViewModel(viewModel: SongFragmentViewModel): BaseFragmentViewModel

    @Module
    companion object {

        @Provides
        @FragmentScope
        @JvmStatic
        fun provideSongRemoteData(apiInterface: SearchApiInterface) =
            SongFragmentRemoteData(apiInterface)

        @Provides
        @FragmentScope
        @JvmStatic
        fun provideSongRepository(
                remote: SongFragmentRemoteData,
                scheduler: Scheduler,
                compositeDisposable: CompositeDisposable
        ) = SongFragmentRepository(remote, scheduler, compositeDisposable)
    }
}