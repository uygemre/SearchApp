package com.base.component.ui.movie

import android.os.Parcelable
import com.base.component.constant.RecyclerviewAdapterConstant
import com.base.core.ui.recyclerview.DisplayItem
import com.base.data.response.MovieResults
import kotlinx.android.parcel.Parcelize

// Created by Emre UYGUN on 2/6/21
// Copyriht © Demiroren Technology. All rights reserved.

@Parcelize
data class MovieDTO(
    var list: MovieResults?
): Parcelable, DisplayItem(RecyclerviewAdapterConstant.TYPES.TYPE_MOVIE)