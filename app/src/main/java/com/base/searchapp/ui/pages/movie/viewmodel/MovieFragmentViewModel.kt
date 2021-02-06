package com.base.searchapp.ui.pages.movie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.base.component.ui.gridrecycler.GridRecyclerDTO
import com.base.component.ui.movie.MovieDTO
import com.base.core.extensions.toLiveData
import com.base.core.ioc.scopes.FragmentScope
import com.base.core.networking.DataFetchResult
import com.base.core.ui.recyclerview.DisplayItem
import com.base.data.response.MovieListResponse
import com.base.searchapp.ui.base.viewmodel.BaseFragmentViewModel
import com.base.searchapp.ui.pages.movie.repository.MovieFragmentRepository
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

/**
 *   Created by Emre UYGUN on 12/5/20
 */

@FragmentScope
class MovieFragmentViewModel @Inject constructor(
    var repository: MovieFragmentRepository
) : BaseFragmentViewModel() {

    val movieList = mutableListOf<DisplayItem>()
    val movieListPublishSubject = PublishSubject.create<List<DisplayItem>>()

    var movieListDataResult: LiveData<DataFetchResult<MovieListResponse>> =
        Transformations.map(repository.movieListDataResult.toLiveData(disposables)) {
            when (it) {
                is DataFetchResult.Progress -> {
                }
                is DataFetchResult.Failure -> {
                }
                is DataFetchResult.Success -> {
                    consumeMovieList(it.data)
                }
            }
            it
        }


    private fun consumeMovieList(response: MovieListResponse?) {
        val list = arrayListOf<MovieDTO>()
        response?.results?.map { _results ->
            list.add(
                MovieDTO(
                    list = _results
                )
            )
        }

        movieList.add(GridRecyclerDTO(list = list))
        movieListPublishSubject.onNext(movieList)
    }

    fun getMovieList(term: String?) {
        repository.getMovieList(term)
    }
}


