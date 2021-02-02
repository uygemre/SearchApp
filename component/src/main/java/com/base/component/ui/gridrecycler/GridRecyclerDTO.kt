package com.base.component.ui.gridrecycler

import android.os.Parcelable
import com.base.component.constant.RecyclerviewAdapterConstant
import com.base.core.ui.recyclerview.DisplayItem
import kotlinx.android.parcel.Parcelize

/**
 *   Created by Emre UYGUN on 2/2/21
 */

@Parcelize
data class GridRecyclerDTO(
    var list: List<DisplayItem>,
    var span: Int? = 2
) : Parcelable, DisplayItem(RecyclerviewAdapterConstant.TYPES.TYPE_GRID_RECYCLER)