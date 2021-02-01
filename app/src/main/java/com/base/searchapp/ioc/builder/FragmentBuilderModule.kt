package com.base.searchapp.ioc.builder

import com.base.core.ioc.scopes.FragmentScope
import com.base.searchapp.ui.pages.book.BookFragment
import com.base.searchapp.ui.pages.book.ioc.BookFragmentModule
import com.base.searchapp.ui.pages.movie.MovieFragment
import com.base.searchapp.ui.pages.movie.ioc.MovieFragmentModule
import com.base.searchapp.ui.pages.software.SoftwareFragment
import com.base.searchapp.ui.pages.software.ioc.SoftwareFragmentModule
import com.base.searchapp.ui.pages.profile.ioc.SongFragmentModule
import com.base.searchapp.ui.pages.song.SongFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [SoftwareFragmentModule::class])
    abstract fun contributeSoftwareFragment(): SoftwareFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [MovieFragmentModule::class])
    abstract fun contributeMovieFragment(): MovieFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [SongFragmentModule::class])
    abstract fun contributeSongFragment(): SongFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [BookFragmentModule::class])
    abstract fun contributeBookFragment(): BookFragment

}