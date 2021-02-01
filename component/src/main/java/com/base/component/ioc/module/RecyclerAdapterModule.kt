package com.base.component.ioc.module

import com.base.component.GoAwayRecyclerviewAdapter
import dagger.Module
import dagger.Provides

@Module
class RecyclerAdapterModule {

	@Provides
	//@Singleton
	fun provideAdapter(): GoAwayRecyclerviewAdapter {
		return GoAwayRecyclerviewAdapter()
	}
}
