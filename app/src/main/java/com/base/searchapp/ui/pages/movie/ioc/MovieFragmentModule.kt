package com.base.searchapp.ui.pages.movie.ioc

import androidx.fragment.app.Fragment
import com.base.core.ioc.scopes.FragmentScope
import com.base.core.networking.Scheduler
import com.base.data.request.SearchApiInterface
import com.base.searchapp.ioc.keys.FragmentViewModelKey
import com.base.searchapp.ui.base.fragment.BaseViewModelFragmentModule
import com.base.searchapp.ui.base.viewmodel.BaseFragmentViewModel
import com.base.searchapp.ui.pages.movie.MovieFragment
import com.base.searchapp.ui.pages.movie.repository.MovieFragmentRemoteData
import com.base.searchapp.ui.pages.movie.repository.MovieFragmentRepository
import com.base.searchapp.ui.pages.movie.viewmodel.MovieFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.reactivex.disposables.CompositeDisposable

/**
 *   Created by Emre UYGUN on 12/5/20
 */

@Module(includes = [BaseViewModelFragmentModule::class])
abstract class MovieFragmentModule {

    @Binds
    @FragmentScope
    abstract fun bindFragment(fragment: MovieFragment): Fragment

    @Binds
    @IntoMap
    @FragmentViewModelKey(MovieFragmentViewModel::class)
    @FragmentScope
    abstract fun bindViewModel(viewModel: MovieFragmentViewModel): BaseFragmentViewModel

    @Module
    companion object {

        @Provides
        @FragmentScope
        @JvmStatic
        fun provideMovieRemoteData(apiInterface: SearchApiInterface) =
            MovieFragmentRemoteData(apiInterface)

        @Provides
        @FragmentScope
        @JvmStatic
        fun provideMovieRepository(
                remote: MovieFragmentRemoteData,
                scheduler: Scheduler,
                compositeDisposable: CompositeDisposable
        ) = MovieFragmentRepository(remote, scheduler, compositeDisposable)
    }
}