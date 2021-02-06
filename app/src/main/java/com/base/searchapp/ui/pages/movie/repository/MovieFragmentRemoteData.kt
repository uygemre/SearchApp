package com.base.searchapp.ui.pages.movie.repository

import com.base.data.request.SearchApiInterface
import com.base.data.response.MovieListResponse
import io.reactivex.Single

/**
 *   Created by Emre UYGUN on 12/5/20
 */

class MovieFragmentRemoteData(
        private val apiInterface: SearchApiInterface
) : MovieFragmentContract.Remote {

        override fun getMovieList(term: String?): Single<MovieListResponse> = apiInterface.getMovieList(term)
}