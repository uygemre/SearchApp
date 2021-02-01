package com.base.data.request

import com.base.data.response.PostResponse
import com.base.data.response.PostSliderReponse
import io.reactivex.Single
import retrofit2.http.*

interface AuthenticatorApiInterface {

    @GET("https://api.canliskor.com.tr/v2/api/{sportType}/Team/GetTeamSquadByTeamId/{teamId}")
    fun getTeamDetailStaffList(): Single<PostSliderReponse>
}