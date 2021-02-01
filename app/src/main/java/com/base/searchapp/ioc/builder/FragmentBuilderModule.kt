package com.base.searchapp.ioc.builder

import com.base.core.ioc.scopes.FragmentScope
import com.base.searchapp.ui.pages.home.HomeFragment
import com.base.searchapp.ui.pages.home.ioc.HomeFragmentModule
import com.base.searchapp.ui.pages.search.SearchFragment
import com.base.searchapp.ui.pages.search.ioc.SearchFragmentModule
import com.base.searchapp.ui.pages.profile.ProfileFragment
import com.base.searchapp.ui.pages.profile.ioc.ProfileFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [SearchFragmentModule::class])
    abstract fun contributeSearchFragment(): SearchFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    abstract fun contributeHomeFragment(): HomeFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [ProfileFragmentModule::class])
    abstract fun contributeProfileFragment(): ProfileFragment

}