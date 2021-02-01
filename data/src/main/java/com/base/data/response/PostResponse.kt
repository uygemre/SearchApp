package com.base.data.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

/*
Created by Muhammed Yusuf Çil
on 11/23/20
*/
@Parcelize
data class PostResponse(
    val title: String?,
    val description: String?,
    val image: String?,
    val rate: String?,
    val created: Date,
    val author: Author,
    val categories: Categories,
    val Adress: Adress
):Parcelable

@Parcelize
data class Adress(
    val city: String?,
    val state: String?
):Parcelable
@Parcelize
data class Categories(
    val key: String?
):Parcelable
@Parcelize
data class Author(
    val userId: String?,
    val userName: String?
):Parcelable