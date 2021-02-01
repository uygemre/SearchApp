package com.base.searchapp.ui.pages.book.ioc

import androidx.fragment.app.Fragment
import com.base.core.ioc.scopes.FragmentScope
import com.base.core.networking.Scheduler
import com.base.data.request.SearchApiInterface
import com.base.searchapp.ioc.keys.FragmentViewModelKey
import com.base.searchapp.ui.base.fragment.BaseViewModelFragmentModule
import com.base.searchapp.ui.base.viewmodel.BaseFragmentViewModel
import com.base.searchapp.ui.pages.book.BookFragment
import com.base.searchapp.ui.pages.book.repository.BookFragmentRemoteData
import com.base.searchapp.ui.pages.book.repository.BookFragmentRepository
import com.base.searchapp.ui.pages.book.viewmodel.BookFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.reactivex.disposables.CompositeDisposable

/**
 *   Created by Emre UYGUN on 2/1/21
 */

@Module(includes = [BaseViewModelFragmentModule::class])
abstract class BookFragmentModule {

    @Binds
    @FragmentScope
    abstract fun bindFragment(fragment: BookFragment): Fragment

    @Binds
    @IntoMap
    @FragmentViewModelKey(BookFragmentViewModel::class)
    @FragmentScope
    abstract fun bindViewModel(viewModel: BookFragmentViewModel): BaseFragmentViewModel

    @Module
    companion object {

        @Provides
        @FragmentScope
        @JvmStatic
        fun provideBookRemoteData(apiInterface: SearchApiInterface) =
                BookFragmentRemoteData(apiInterface)

        @Provides
        @FragmentScope
        @JvmStatic
        fun provideBookRepository(
                remote: BookFragmentRemoteData,
                scheduler: Scheduler,
                compositeDisposable: CompositeDisposable
        ) = BookFragmentRepository(remote, scheduler, compositeDisposable)
    }
}