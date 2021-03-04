package com.base.component.ui.software

import android.os.Parcelable
import com.base.component.constant.RecyclerviewAdapterConstant
import com.base.core.ui.recyclerview.DisplayItem
import com.base.data.response.SearchResults
import kotlinx.android.parcel.Parcelize

// Created by Emre UYGUN on 2/13/21
// Copyriht © Demiroren Technology. All rights reserved.

@Parcelize
data class SoftwareDTO(
    var list: SearchResults?
) : Parcelable, DisplayItem(RecyclerviewAdapterConstant.TYPES.TYPE_SOFTWARE)