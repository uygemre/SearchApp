package com.base.data.request

import io.reactivex.Single
import com.base.data.base.UserProfile
import retrofit2.http.GET

interface UserProfileApiInterface {
    @GET("user_profile.json")
    fun userProfile(): Single<UserProfile>
}