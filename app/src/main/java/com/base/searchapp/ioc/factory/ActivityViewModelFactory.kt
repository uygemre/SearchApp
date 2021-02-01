@file:Suppress("UNCHECKED_CAST")

package com.base.searchapp.ioc.factory

import androidx.lifecycle.ViewModel
import com.base.core.ioc.scopes.ActivityScope
import com.base.searchapp.ui.base.viewmodel.BaseActivityViewModel
import javax.inject.Inject
import javax.inject.Provider

@ActivityScope
class ActivityViewModelFactory @Inject constructor(
    creators: Map<Class<out BaseActivityViewModel>
            , @JvmSuppressWildcards Provider<BaseActivityViewModel>>
) : BaseViewModelFactory(creators as Map<Class<out ViewModel>, Provider<ViewModel>>)