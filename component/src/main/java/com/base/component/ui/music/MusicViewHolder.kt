package com.base.component.ui.music

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.base.component.R
import com.base.core.extensions.loadImage
import com.base.core.ui.recyclerview.DisplayItem
import com.base.core.ui.recyclerview.ViewHolder
import com.base.core.ui.recyclerview.ViewHolderBinder
import com.base.core.ui.recyclerview.ViewHolderFactory
import org.w3c.dom.Text
import javax.inject.Inject

/**
 *   Created by Emre UYGUN on 2/2/21
 */

class MusicViewHolder(var view: View) : ViewHolder<MusicDTO>(view) {

    private var ivSong = view.findViewById<ImageView>(R.id.iv_song)
    private var tvArtistName = view.findViewById<TextView>(R.id.tv_artist_name)
    private var tvTrackName = view.findViewById<TextView>(R.id.tv_track_name)

    override fun bind(item: MusicDTO) {
        item.list?.let { _list ->
            ivSong.loadImage(_list.artworkUrl100 ?: "")
            tvArtistName.text = _list.artistName
            tvTrackName.text = _list.trackName
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