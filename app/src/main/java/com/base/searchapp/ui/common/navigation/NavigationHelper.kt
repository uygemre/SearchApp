package com.base.searchapp.ui.common.navigation

import android.app.Activity
import android.os.Bundle
import com.base.component.ui.movie.MovieDTO
import com.base.core.extensions.openActivity
import com.base.core.ui.recyclerview.DisplayItem
import com.base.searchapp.ui.common.enums.IntentBundleKeyEnum
import com.base.searchapp.ui.pages.detail.DetailActivity

// Created by Emre UYGUN on 2/14/21
// Copyriht © Demiroren Technology. All rights reserved.

class NavigationHelper(var activity: Activity) {

    fun navigate(item: DisplayItem) {
        val bundle = Bundle()
        when (item) {
            /*
            is VideoGamesCardsDTO -> {
                bundle.putString(
                    IntentBundleKeyEnum.DETAIL_KEY.toString(),
                    IntentBundleKeyEnum.DETAIL_GAMES_CARD.toString()
                )
                bundle.putString("slug", item.slug)
            }

             */

            is MovieDTO -> {
                bundle.putString(
                    IntentBundleKeyEnum.DETAIL_KEY.toString(),
                    IntentBundleKeyEnum.DETAIL_MOVIE.toString()
                )
                bundle.putString("trackName", item.list?.trackName)
            }
        }

        activity.openActivity(DetailActivity::class.java, bundle)
    }
}