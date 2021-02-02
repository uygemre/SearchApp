package com.base.component.ioc.module

import com.base.component.SearchAppRecyclerviewAdapter
import dagger.Module
import dagger.Provides

@Module
class RecyclerAdapterModule {

	@Provides
	//@Singleton
	fun provideAdapter(): SearchAppRecyclerviewAdapter {
		return SearchAppRecyclerviewAdapter()
	}
}
