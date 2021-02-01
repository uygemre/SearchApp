package com.base.component.ui.homepageslider

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.base.component.R
import com.base.core.extensions.loadImage
import com.squareup.picasso.Picasso


class HomePageSliderViewPagerAdapter(
    context: Context,
    itemList: ArrayList<SliderItem>,
    isInfinite: Boolean,
    private val sliderClickListener: ISliderClickListener
) : LoopingPagerAdapter<SliderItem>(context, itemList, isInfinite) {

    override fun inflateView(viewType: Int, container: ViewGroup?, position: Int): View {
        val item = itemList[position]
        return when (item.newsType) {
            "news" -> {
                LayoutInflater.from(context)
                    .inflate(R.layout.item_slider, container, false)
            }
            else -> {
                LayoutInflater.from(context)
                    .inflate(R.layout.item_slider, container, false)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun bindView(view: View?, position: Int, viewType: Int) {
        val item = itemList[position]
        when (item.newsType) {
            "news" -> {
                val tvSliderPlaceName =
                    view?.findViewById<TextView>(R.id.txt_home_slider_place_name)
                val tvSliderPlaceInformation =
                    view!!.findViewById<TextView>(R.id.txt_home_slider_place_information)
                val sliderPhoto = view?.findViewById<ImageView>(R.id.img_home_page_slider)
                val rootViewSlider = view.findViewById<CardView>(R.id.rootView)
                item?.placeName.let {
                    tvSliderPlaceName?.text = it
                }
                item.desc.let {
                    tvSliderPlaceInformation.text = it
                }
                item?.photoPath.let {
                    Picasso.with(context).load(item?.photoPath).into(sliderPhoto)
                }

                rootViewSlider?.setOnClickListener {
                    sliderClickListener.onClickListener(position, item)
                }
                sliderPhoto?.loadImage(item.photoPath!!)
            }
            "ads" -> {
            }
        }
    }
}