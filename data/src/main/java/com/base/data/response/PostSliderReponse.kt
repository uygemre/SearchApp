package com.base.data.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/*
Created by Muhammed Yusuf Çil
on 11/23/20
*/

@Parcelize
data class PostSliderReponse(
    val title: String?,
    val image: String?
):Parcelable