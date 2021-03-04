package com.base.data.request

import com.base.data.response.*
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApiInterface {

    @GET("https://itunes.apple.com/search?")
    fun getSearchList(
        @Query("term") term: String?,
        @Query("media") media: String?,
        @Query("limit") limit: Int? = 20
    ): Single<SearchListResponse>
}