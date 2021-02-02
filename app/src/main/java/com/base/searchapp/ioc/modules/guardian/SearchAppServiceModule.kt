package com.base.searchapp.ioc.modules.guardian

import com.base.core.ioc.scopes.ActivityScope
import com.base.data.request.SearchApiInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
abstract class SearchAppServiceModule {

    @Module
    companion object {

        @Provides
        @ActivityScope
        @JvmStatic
        fun provideGuardianSearchInterface(retrofit: Retrofit): SearchApiInterface =
            retrofit.create(SearchApiInterface::class.java)

    }
}
