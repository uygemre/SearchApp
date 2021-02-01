package com.base.searchapp.ui.pages.book

import android.os.Bundle
import android.view.View
import com.base.searchapp.R
import com.base.searchapp.ui.base.fragment.BaseViewModelFragment
import com.base.searchapp.ui.pages.book.viewmodel.BookFragmentViewModel

/**
 *   Created by Emre UYGUN on 2/1/21
 */

class BookFragment : BaseViewModelFragment<BookFragmentViewModel>() {

    override val viewModelClass = BookFragmentViewModel::class.java
    override val layoutViewRes = R.layout.fragment_book

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}