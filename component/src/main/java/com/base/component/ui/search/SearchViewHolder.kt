package com.base.component.ui.search

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.base.component.R
import com.base.core.extensions.gone
import com.base.core.extensions.loadImage
import com.base.core.ui.recyclerview.DisplayItem
import com.base.core.ui.recyclerview.ViewHolder
import com.base.core.ui.recyclerview.ViewHolderBinder
import com.base.core.ui.recyclerview.ViewHolderFactory
import com.base.core.utils.TimeUtil
import javax.inject.Inject

// Created by Emre UYGUN on 2/6/21
// Copyriht © Demiroren Technology. All rights reserved.

class SearchViewHolder(var view: View) : ViewHolder<SearchDTO>(view) {

    private var ivMovie = view.findViewById<ImageView>(R.id.iv_movie)
    private var tvMovieName = view.findViewById<TextView>(R.id.tv_movie_name)
    private var tvPrice = view.findViewById<TextView>(R.id.tv_price)
    private var tvReleaseDate = view.findViewById<TextView>(R.id.tv_release_date)

    @SuppressLint("SetTextI18n")
    override fun bind(item: SearchDTO) {
        item.list.let {
            ivMovie.loadImage(it?.artworkUrl100 ?: "")
            tvMovieName.text = it?.trackName
            tvPrice.text = "${it?.trackPrice ?: tvPrice.gone()} $"
            tvReleaseDate.text = TimeUtil.dateDiff2(date = it?.releaseDate ?: "", format = "yyyy-MM-dd")
        }
    }

    class HolderFactory @Inject constructor() : ViewHolderFactory {
        override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
            SearchViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_movie,
                    parent,
                    false
                )
            )
    }

    class BinderFactory @Inject constructor() : ViewHolderBinder {
        override fun bind(holder: RecyclerView.ViewHolder, item: DisplayItem) {
            (holder as SearchViewHolder).bind(item as SearchDTO)
        }
    }
}