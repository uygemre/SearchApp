@file:Suppress("unused")

package com.base.searchapp.ui.pages.main.ioc

import androidx.appcompat.app.AppCompatActivity
import com.base.core.ioc.scopes.ActivityScope
import com.base.core.networking.Scheduler
import com.base.searchapp.ioc.modules.guardian.SearchAppServiceModule
import com.base.searchapp.ioc.builder.FragmentBuilderModule
import com.base.searchapp.ioc.keys.ActivityViewModelKey
import com.base.searchapp.ui.pages.main.MainActivity
import com.base.searchapp.ui.pages.main.viewmodel.MainActivityViewModel
import com.base.searchapp.ui.base.activity.BaseActivityModule
import com.base.searchapp.ui.base.viewmodel.BaseActivityViewModel
import com.base.data.request.SearchApiInterface
import com.base.searchapp.ui.pages.main.repository.MainActivityRemoteData
import com.base.searchapp.ui.pages.main.repository.MainActivityRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.reactivex.disposables.CompositeDisposable

/**
 *   Created by Emre UYGUN on 12/5/20
 */

@Module(includes = [BaseActivityModule::class, FragmentBuilderModule::class, SearchAppServiceModule::class])
abstract class MainActivityModule {

    @Binds
    @ActivityScope
    abstract fun bindActivity(activity: MainActivity): AppCompatActivity

    @Binds
    @IntoMap
    @ActivityViewModelKey(MainActivityViewModel::class)
    @ActivityScope
    abstract fun bindViewModel(activityViewModel: MainActivityViewModel): BaseActivityViewModel

    @Module
    companion object {

        @Provides
        @ActivityScope
        @JvmStatic
        fun provideHomeActivityRemoteData(apiInterface: SearchApiInterface) =
            MainActivityRemoteData(apiInterface)

        @Provides
        @ActivityScope
        @JvmStatic
        fun provideHomeActivityRepository(
            remote: MainActivityRemoteData,
            scheduler: Scheduler,
            compositeDisposable: CompositeDisposable
        ) = MainActivityRepository(remote, scheduler, compositeDisposable)
    }
}
