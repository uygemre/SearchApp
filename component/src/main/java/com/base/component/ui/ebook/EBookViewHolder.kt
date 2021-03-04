package com.base.component.ui.ebook

import android.annotation.SuppressLint
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

class EBookViewHolder(var view: View) : ViewHolder<EBookDTO>(view) {

    private var rootView = view.findViewById<LinearLayout>(R.id.rootEBook)
    private val ivEBook = view.findViewById<ImageView>(R.id.iv_ebook)
    private val tvEBookName = view.findViewById<TextView>(R.id.tv_ebook_name)
    private val tvEBookGenre = view.findViewById<TextView>(R.id.tv_ebook_genre)
    private val tvEBookArtistName = view.findViewById<TextView>(R.id.tv_ebook_artist_name)

    @SuppressLint("SetTextI18n")
    override fun bind(item: EBookDTO) {
        item.list.let {
            ivEBook.loadImage(it?.artworkUrl100 ?: "")
            if (it?.averageUserRating != null ) {
                tvEBookName.text = "${it?.trackName} (${it?.averageUserRating})"
            } else
                tvEBookName.text = it?.trackName
            tvEBookGenre.text = it?.genres.let { _genres ->
                _genres?.get(0) ?: ""
            }
            tvEBookArtistName.text = it?.artistName
        }
        rootView.setOnClickListener {
            itemClickListener?.invoke(item, adapterPosition)
        }
    }

    class HolderFactory @Inject constructor() : ViewHolderFactory {
        override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
            EBookViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_ebook,
                    parent,
                    false
                )
            )
    }

    class BinderFactory @Inject constructor() : ViewHolderBinder {
        override fun bind(holder: RecyclerView.ViewHolder, item: DisplayItem) {
            (holder as EBookViewHolder).bind(item as EBookDTO)
        }
    }
}