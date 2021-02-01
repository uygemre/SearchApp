package com.base.data.request

import com.base.data.response.PostResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApiInterface {

    @GET("search")
    fun getLatestNews(@Query("q") q: String?, @Query("show-fields") showFields: String): Single<PostResponse>

}