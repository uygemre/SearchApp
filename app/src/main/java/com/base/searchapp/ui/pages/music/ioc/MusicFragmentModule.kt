package com.base.searchapp.ui.pages.music.ioc

import androidx.fragment.app.Fragment
import com.base.core.ioc.scopes.FragmentScope
import com.base.core.networking.Scheduler
import com.base.data.request.SearchApiInterface
import com.base.searchapp.ioc.keys.FragmentViewModelKey
import com.base.searchapp.ui.base.fragment.BaseViewModelFragmentModule
import com.base.searchapp.ui.base.viewmodel.BaseFragmentViewModel
import com.base.searchapp.ui.pages.music.repository.MusicFragmentRemoteData
import com.base.searchapp.ui.pages.music.repository.MusicFragmentRepository
import com.base.searchapp.ui.pages.music.viewmodel.MusicFragmentViewModel
import com.base.searchapp.ui.pages.music.MusicFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.reactivex.disposables.CompositeDisposable

/**
 *   Created by Emre UYGUN on 12/5/20
 */

@Module(includes = [BaseViewModelFragmentModule::class])
abstract class MusicFragmentModule {

    @Binds
    @FragmentScope
    abstract fun bindFragment(fragment: MusicFragment): Fragment

    @Binds
    @IntoMap
    @FragmentViewModelKey(MusicFragmentViewModel::class)
    @FragmentScope
    abstract fun bindViewModel(viewModel: MusicFragmentViewModel): BaseFragmentViewModel

    @Module
    companion object {

        @Provides
        @FragmentScope
        @JvmStatic
        fun provideMusicRemoteData(apiInterface: SearchApiInterface) =
            MusicFragmentRemoteData(apiInterface)

        @Provides
        @FragmentScope
        @JvmStatic
        fun provideMusicRepository(
            remote: MusicFragmentRemoteData,
            scheduler: Scheduler,
            compositeDisposable: CompositeDisposable
        ) = MusicFragmentRepository(remote, scheduler, compositeDisposable)
    }
}