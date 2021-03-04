package com.base.searchapp.ui.pages.main

import android.content.Intent
import android.os.Bundle
import com.base.component.SearchAppRecyclerviewAdapter
import com.base.component.ui.ebook.EBookDTO
import com.base.component.ui.gridrecycler.GridRecyclerDTO
import com.base.component.ui.movie.MovieDTO
import com.base.component.ui.music.MusicDTO
import com.base.component.ui.search.SearchDTO
import com.base.component.ui.software.SoftwareDTO
import com.base.core.extensions.*
import com.base.core.networking.DataFetchResult
import com.base.core.ui.recyclerview.DisplayItem
import com.base.data.response.SearchResults
import com.base.searchapp.R
import com.base.searchapp.ui.base.activity.BaseActivity
import com.base.searchapp.ui.common.navigation.NavigationHelper
import com.base.searchapp.ui.pages.detail.DetailActivity
import com.base.searchapp.ui.pages.main.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 *   Created by Emre UYGUN on 12/5/20
 */

class MainActivity : BaseActivity<MainActivityViewModel>() {

    override val viewModelClass = MainActivityViewModel::class.java
    override val layoutViewRes = R.layout.activity_main

    @Inject
    lateinit var adapter: SearchAppRecyclerviewAdapter

    private var term: String? = ""
    private var media: String? = "movie"
    private val searchList = mutableListOf<DisplayItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        rv_search.setup(adapter = adapter.getAdapter())

        val navigationHelper = NavigationHelper(this)
        adapter.getAdapter().itemClickListener = { item, position ->
            when (item) {
                is MovieDTO -> {
                    openDetailActivity(item.list)
                }
                is MusicDTO -> {
                    openDetailActivity(item.list)
                }
                is SoftwareDTO -> {
                    openDetailActivity(item.list)
                }
                is EBookDTO -> {
                    openDetailActivity(item.list)
                }
            }
        }

        et_search.afterTextChanged {
            if (et_search.text.length > 3) {
                radioGroup.visibile()
                viewModel.getSearchList(et_search.text.toString().toLowerCase(), media)
            }
        }

        viewModel.searchListPublishSubject.subscribe {
            when (it) {
                is DataFetchResult.Progress -> {
                }
                is DataFetchResult.Failure -> {
                }
                is DataFetchResult.Success -> {
                    searchList.clear()
                    val list = arrayListOf<DisplayItem>()
                    it.data.let { _response ->
                        _response.results?.map { _results ->

                            when (_results?.kind) {
                                "song" -> {
                                    list.add(
                                        MusicDTO(
                                            list = _results
                                        )
                                    )
                                }
                                "feature-movie" -> {
                                    list.add(
                                        MovieDTO(
                                            list = _results
                                        )
                                    )
                                }
                                "software" -> {
                                    list.add(
                                        SoftwareDTO(
                                            list = _results
                                        )
                                    )
                                }
                                "ebook" -> {
                                    list.add(
                                        EBookDTO(
                                            list = _results
                                        )
                                    )
                                }

                                else -> list
                            }
                        }
                    }

                    if (it.data.results.isNullOrEmpty()) {
                        tv_no_data_found.visibile()
                    } else
                        tv_no_data_found.gone()

                    searchList.add(GridRecyclerDTO(list = list))
                    adapter.getAdapter().updateAllItems(searchList)
                }
            }
        }.isDisposed

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            term = et_search.text.toString().toLowerCase()
            when (checkedId) {
                R.id.rb_movie -> {
                    media = "movie"
                }
                R.id.rb_song -> {
                    media = "music"
                }
                R.id.rb_software -> {
                    media = "software"
                }
                R.id.rb_book -> {
                    media = "ebook"
                }
            }

            viewModel.getSearchList(term, media)
        }
    }

    private fun openDetailActivity(item: SearchResults?) {
        val intent: Intent? = Intent(this, DetailActivity::class.java)
        intent?.putExtra("item", item)
        startActivity(intent)
    }
}
