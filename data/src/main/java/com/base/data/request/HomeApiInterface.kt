package com.base.data.request

import com.base.data.response.PostResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApiInterface {


    @GET("software")
    fun getSearch(@Query("q") q: String?, @Query("show-fields") showFields: String): Single<PostResponse>

    @GET("software")
    fun getLatestNews(@Query("show-fields") showFields: String): Single<PostResponse>
}