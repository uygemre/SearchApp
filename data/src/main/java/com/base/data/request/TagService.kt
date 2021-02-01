package com.base.data.request

import com.base.data.response.PostResponse
import io.reactivex.Single
import retrofit2.http.GET

interface TagService {

  @GET("tags")
  fun getAllTags(): Single<PostResponse>
}