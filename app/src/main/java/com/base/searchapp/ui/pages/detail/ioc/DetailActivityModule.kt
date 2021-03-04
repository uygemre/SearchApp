package com.base.searchapp.ui.pages.detail.ioc

import androidx.appcompat.app.AppCompatActivity
import com.base.core.ioc.scopes.ActivityScope
import com.base.core.networking.Scheduler
import com.base.data.request.SearchApiInterface
import com.base.searchapp.ioc.builder.FragmentBuilderModule
import com.base.searchapp.ioc.keys.ActivityViewModelKey
import com.base.searchapp.ioc.modules.guardian.SearchAppServiceModule
import com.base.searchapp.ui.base.activity.BaseActivityModule
import com.base.searchapp.ui.base.viewmodel.BaseActivityViewModel
import com.base.searchapp.ui.pages.detail.DetailActivity
import com.base.searchapp.ui.pages.detail.repository.DetailActivityRemoteData
import com.base.searchapp.ui.pages.detail.repository.DetailActivityRepository
import com.base.searchapp.ui.pages.detail.viewmodel.DetailActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.reactivex.disposables.CompositeDisposable

// Created by Emre UYGUN on 2/14/21
// Copyriht © Demiroren Technology. All rights reserved.

@Module(includes = [BaseActivityModule::class, FragmentBuilderModule::class, SearchAppServiceModule::class])
abstract class DetailActivityModule {

    @Binds
    @ActivityScope
    abstract fun bindActivity(activity: DetailActivity): AppCompatActivity

    @Binds
    @IntoMap
    @ActivityViewModelKey(DetailActivityViewModel::class)
    @ActivityScope
    abstract fun bindViewModel(activityViewModel: DetailActivityViewModel): BaseActivityViewModel

    @Module
    companion object {

        @Provides
        @ActivityScope
        @JvmStatic
        fun provideDetailActivityRemoteData(apiInterface: SearchApiInterface) =
            DetailActivityRemoteData(apiInterface)

        @Provides
        @ActivityScope
        @JvmStatic
        fun provideDetailActivityRepository(
            remote: DetailActivityRemoteData,
            scheduler: Scheduler,
            compositeDisposable: CompositeDisposable
        ) = DetailActivityRepository(remote, scheduler, compositeDisposable)
    }
}