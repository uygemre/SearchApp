package com.base.searchapp.ioc.modules.guardian

import com.base.core.ioc.scopes.ActivityScope
import com.base.data.request.AuthenticatorApiInterface
import com.base.data.request.SearchApiInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
abstract class GuardianServiceModule {

    @Module
    companion object {

        @Provides
        @ActivityScope
        @JvmStatic
        fun provideGuardianSearchInterface(retrofit: Retrofit): SearchApiInterface =
            retrofit.create(SearchApiInterface::class.java)


        @Singleton
        @Provides
        fun provideIMatchDetailApi(retrofit: Retrofit): AuthenticatorApiInterface =
            retrofit.create(AuthenticatorApiInterface::class.java)
    }
}
