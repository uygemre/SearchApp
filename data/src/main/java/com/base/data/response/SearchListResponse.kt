package com.base.data.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *   Created by Emre UYGUN on 2/2/21
 */

@Parcelize
data class SearchListResponse(
    var results: List<SearchResults?>?
) : Parcelable

@Parcelize
data class SearchResults(
    val wrapperType: String?,
    val kind: String?,
    val trackId: Int?,
    val artistName: String?,
    val trackName: String?,
    val trackCensoredName: String?,
    val trackViewUrl: String?,
    val previewUrl: String?,
    val artworkUrl30: String?,
    val artworkUrl60: String?,
    val artworkUrl100: String?,
    val collectionPrice: Double?,
    val trackPrice: Double?,
    val trackRentalPrice: Double?,
    val collectionHdPrice: Double?,
    val trackHdPrice: Double?,
    val trackHdRentalrice: Double?,
    val releaseDate: String?,
    val collectionExplicitness: String?,
    val trackExplicitness: String?,
    val trackTimeMillis: Int?,
    val country: String?,
    val currency: String?,
    val primaryGenreName: String?,
    val contentAdvisoryRating: String?,
    val shortDescription: String?,
    val longDescription: String?,
    val collectionName: String?,
    val genres: List<String?>? = emptyList(),
    val averageUserRating: Double?
) : Parcelable