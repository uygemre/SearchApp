package com.base.searchapp.ui.pages.book.viewmodel

import com.base.core.ioc.scopes.FragmentScope
import com.base.searchapp.ui.base.viewmodel.BaseFragmentViewModel
import com.base.searchapp.ui.pages.book.repository.BookFragmentRepository
import javax.inject.Inject

/**
 *   Created by Emre UYGUN on 2/1/21
 */

@FragmentScope
class BookFragmentViewModel @Inject constructor(
        var repository: BookFragmentRepository
) : BaseFragmentViewModel() {

}