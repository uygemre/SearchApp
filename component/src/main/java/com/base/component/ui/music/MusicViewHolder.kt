package com.base.component.ui.music

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.base.component.R
import com.base.core.extensions.loadImage
import com.base.core.ui.recyclerview.DisplayItem
import com.base.core.ui.recyclerview.ViewHolder
import com.base.core.ui.recyclerview.ViewHolderBinder
import com.base.core.ui.recyclerview.ViewHolderFactory
import javax.inject.Inject

/**
 *   Created by Emre UYGUN on 2/2/21
 */

class MusicViewHolder(var view: View) : ViewHolder<MusicDTO>(view) {

    private var imgMusic = view.findViewById<ImageView>(R.id.img_music)

    override fun bind(item: MusicDTO) {
        imgMusic.loadImage(item.artworkUrl100 ?: "")
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