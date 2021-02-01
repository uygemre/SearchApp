package com.base.searchapp.ioc.builder

import com.base.core.ioc.scopes.ActivityScope
import com.base.searchapp.ui.pages.main.MainActivity
import com.base.searchapp.ui.pages.main.ioc.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun bindMainActivity(): MainActivity

}