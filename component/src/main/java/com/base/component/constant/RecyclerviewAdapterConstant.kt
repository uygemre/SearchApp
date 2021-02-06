package com.base.component.constant

import com.base.component.ui.gridrecycler.GridRecyclerViewHolder
import com.base.component.ui.homepageslider.HomePageSliderViewHolder
import com.base.component.ui.horizontalrecycler.HorizontalRecyclerViewHolder
import com.base.component.ui.movie.MovieViewHolder
import com.base.component.ui.music.MusicViewHolder

class RecyclerviewAdapterConstant {

    object TYPES {
        const val TYPE_NONE = 0
        const val TYPE_HORIZONTAL_RECYCLER = 1
        const val TYPE_HOME_PAGE_SLIDER = 2
        const val TYPE_SLIDER_ITEM = 3
        const val TYPE_GRID_RECYCLER = 4
        const val TYPE_MUSIC = 5
        const val TYPE_MOVIE = 6
        const val TYPE_SOFTWARE = 7
        const val TYPE_BOOK = 8
    }

    var binderFactoryMap = mutableMapOf(
        TYPES.TYPE_HORIZONTAL_RECYCLER to HorizontalRecyclerViewHolder.BinderFactory(),
        TYPES.TYPE_HOME_PAGE_SLIDER to HomePageSliderViewHolder.BinderFactory(),
        TYPES.TYPE_GRID_RECYCLER to GridRecyclerViewHolder.BinderFactory(),
        TYPES.TYPE_MUSIC to MusicViewHolder.BinderFactory(),
        TYPES.TYPE_MOVIE to MovieViewHolder.BinderFactory()
    )

    var holderFactoryMap = mutableMapOf(
        TYPES.TYPE_HORIZONTAL_RECYCLER to HorizontalRecyclerViewHolder.HolderFactory(),
        TYPES.TYPE_HOME_PAGE_SLIDER to HomePageSliderViewHolder.HolderFactory(),
        TYPES.TYPE_GRID_RECYCLER to GridRecyclerViewHolder.HolderFactory(),
        TYPES.TYPE_MUSIC to MusicViewHolder.HolderFactory(),
        TYPES.TYPE_MOVIE to MovieViewHolder.HolderFactory()
    )
}
