package com.base.component.ui.software

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
import com.base.core.utils.TimeUtil
import javax.inject.Inject

// Created by Emre UYGUN on 2/13/21
// Copyriht © Demiroren Technology. All rights reserved.

class SoftwareViewHolder(var view: View) : ViewHolder<SoftwareDTO>(view) {

    private var rootView = view.findViewById<LinearLayout>(R.id.rootSoftware)
    private val ivSoftware = view.findViewById<ImageView>(R.id.iv_software)
    private val tvSoftwareName = view.findViewById<TextView>(R.id.tv_software_name)
    private val tvSoftwareGenre = view.findViewById<TextView>(R.id.tv_software_genre)

    @SuppressLint("SetTextI18n")
    override fun bind(item: SoftwareDTO) {
        item.list?.let {
            ivSoftware.loadImage(it.artworkUrl100 ?: "")
            tvSoftwareName.text = "${it.trackName} (${TimeUtil.dateDiff2(date = it.releaseDate ?: "", format = "yyyy")})"
            tvSoftwareGenre.text = it.primaryGenreName
        }
        rootView.setOnClickListener {
            itemClickListener?.invoke(item, adapterPosition)
        }
    }


    class HolderFactory @Inject constructor() : ViewHolderFactory {
        override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
            SoftwareViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_software,
                    parent,
                    false
                )
            )
    }

    class BinderFactory @Inject constructor() : ViewHolderBinder {
        override fun bind(holder: RecyclerView.ViewHolder, item: DisplayItem) {
            (holder as SoftwareViewHolder).bind(item as SoftwareDTO)
        }
    }
}