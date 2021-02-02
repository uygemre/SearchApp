package com.base.component.ui.gridrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.base.component.R
import com.base.component.constant.RecyclerviewAdapterConstant
import com.base.core.extensions.setup
import com.base.core.ui.recyclerview.*
import javax.inject.Inject

/**
 *   Created by Emre UYGUN on 2/2/21
 */

class GridRecyclerViewHolder(var view: View) : ViewHolder<GridRecyclerDTO>(view) {

    private var rvGrid = view.findViewById<RecyclerView>(R.id.rv_grid)

    override fun bind(item: GridRecyclerDTO) {

        val adapter = RecyclerViewAdapter(
            itemComparator = DefaultDisplayItemComperator(),
            viewBinderFactoryMap = RecyclerviewAdapterConstant().binderFactoryMap,
            viewHolderFactoryMap = RecyclerviewAdapterConstant().holderFactoryMap
        )

        adapter.itemClickListener = { _item, _position ->
            itemClickListener?.invoke(_item, _position)
        }
        val layoutManager =
            GridLayoutManager(view.context, item.span ?: 2)
        rvGrid.setup(adapter, layoutManager)
        adapter.updateAllItems(item.list)

    }

    class HolderFactory @Inject constructor() : ViewHolderFactory {
        override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
            GridRecyclerViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_grid_recycler,
                    parent,
                    false
                )
            )
    }

    class BinderFactory @Inject constructor() : ViewHolderBinder {
        override fun bind(holder: RecyclerView.ViewHolder, item: DisplayItem) {
            (holder as GridRecyclerViewHolder).bind(item as GridRecyclerDTO)
        }
    }
}