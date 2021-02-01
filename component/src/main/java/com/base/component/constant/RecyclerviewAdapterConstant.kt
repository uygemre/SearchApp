package com.base.component.constant

import com.base.component.ui.homepageslider.HomePageSliderViewHolder
import com.base.component.ui.horizontalrecycler.HorizontalRecyclerViewHolder

class RecyclerviewAdapterConstant {

    object TYPES {
        const val TYPE_NONE = 0
        const val TYPE_HORIZONTAL_RECYCLER = 1
        const val TYPE_HOME_PAGE_SLIDER = 2
        const val TYPE_SLIDER_ITEM = 3
    }

    var binderFactoryMap = mutableMapOf(
        TYPES.TYPE_HORIZONTAL_RECYCLER to HorizontalRecyclerViewHolder.BinderFactory(),
        TYPES.TYPE_HOME_PAGE_SLIDER to HomePageSliderViewHolder.BinderFactory()
    )

    var holderFactoryMap = mutableMapOf(
        TYPES.TYPE_HORIZONTAL_RECYCLER to HorizontalRecyclerViewHolder.HolderFactory(),
        TYPES.TYPE_HOME_PAGE_SLIDER to HomePageSliderViewHolder.HolderFactory()
    )
}
