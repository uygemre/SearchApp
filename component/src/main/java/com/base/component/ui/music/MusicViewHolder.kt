package com.base.component.ui.music

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.base.component.R
import com.base.core.extensions.loadImage
import com.base.core.ui.recyclerview.DisplayItem
import com.base.core.ui.recyclerview.ViewHolder
import com.base.core.ui.recyclerview.ViewHolderBinder
import com.base.core.ui.recyclerview.ViewHolderFactory
import javax.inject.Inject

// Created by Emre UYGUN on 2/13/21
// Copyriht © Demiroren Technology. All rights reserved.

class MusicViewHolder(var view: View) : ViewHolder<MusicDTO>(view) {

    private var rootView = view.findViewById<LinearLayout>(R.id.rootMusic)
    private var imgMusic = view.findViewById<ImageView>(R.id.iv_song)
    private var tvTrackName = view.findViewById<TextView>(R.id.tv_track_name)
    private var tvArtistName = view.findViewById<TextView>(R.id.tv_artist_name)

    override fun bind(item: MusicDTO) {
        item.list.let {
            imgMusic.loadImage(it?.artworkUrl100 ?: "")
            tvTrackName.text = it?.trackName
            tvArtistName.text = it?.artistName
        }
        rootView.setOnClickListener {
            itemClickListener?.invoke(item, adapterPosition)
        }
    }

    class HolderFactory @Inject constructor() : ViewHolderFactory {
        override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
            MusicViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_music,
                    parent,
                    false
                )
            )
    }

    class BinderFactory @Inject constructor() : ViewHolderBinder {
        override fun bind(holder: RecyclerView.ViewHolder, item: DisplayItem) {
            (holder as MusicViewHolder).bind(item as MusicDTO)
        }
    }
}