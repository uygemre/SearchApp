package com.base.component.ui.music

import android.os.Parcelable
import com.base.component.constant.RecyclerviewAdapterConstant
import com.base.core.ui.recyclerview.DisplayItem
import com.base.data.response.MusicListResponse
import com.base.data.response.MusicResults
import kotlinx.android.parcel.Parcelize

/**
 *   Created by Emre UYGUN on 2/2/21
 */

@Parcelize
data class MusicDTO(
    /*
    val wrapperType: String? = "",
    val kind: String? = "",
    val artistId: Int? = 0,
    val collectionId: Int? = 0,
    val trackId: Int? = 0,
    val artistName: String? = "",
    val collectionName: String? = "",
    val trackName: String? = "",
    val collectionCensoredName: String? = "",
    val trackCensoredName: String? = "",
    val artistViewUrl: String? = "",
    val collectionViewUrl: String? = "",
    val trackViewUrl: String? = "",
    val previewUrl: String? = "",
    val artworkUrl30: String? = "",
    val artworkUrl60: String? = "",
    val artworkUrl100: String? = "",
    val collectionPrice: Double? = 0.0,
    val trackPrice: Double? = 0.0,
    val releaseDate: String? = "",
    val collectionExplicitness: String? = "",
    val trackExplicitness: String? = "",
    val trackTimeMillis: Int? = 0,
    val discCount: Int? = 0,
    val discNumber: Int? = 0,
    val trackCount: Int? = 0,
    val trackNumber: Int? = 0,
    val country: String? = "",
    val currency: String? = "",
    val primaryGenreName: String? = ""

     */

    var list: MusicResults?
) : Parcelable, DisplayItem(RecyclerviewAdapterConstant.TYPES.TYPE_MUSIC)