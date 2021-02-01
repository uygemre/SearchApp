package com.base.searchapp.ui.pages.movie.viewmodel

import android.util.Log
import com.base.core.ioc.scopes.FragmentScope
import com.base.core.ui.recyclerview.DisplayItem
import com.base.searchapp.ui.base.viewmodel.BaseFragmentViewModel
import com.base.searchapp.ui.pages.movie.repository.MovieFragmentRepository
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

/**
 *   Created by Emre UYGUN on 12/5/20
 */

@FragmentScope
class MovieFragmentViewModel @Inject constructor(
    var repository: MovieFragmentRepository
) : BaseFragmentViewModel() {

    var TAG = "DOCUMENT_MESSAGE"

    private val homePageItemList = mutableListOf<DisplayItem>()

    val db = Firebase.firestore
    //val cities = db.collection("cities")

    fun getDataStorage() {
        db.collection("Address")
            //.whereEqualTo("capital", true)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents: ", exception)
            }
    }
}


