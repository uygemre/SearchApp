package com.base.searchapp.ui.pages.music.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.base.component.ui.gridrecycler.GridRecyclerDTO
import com.base.component.ui.music.MusicDTO
import com.base.core.extensions.toLiveData
import com.base.core.ioc.scopes.FragmentScope
import com.base.core.networking.DataFetchResult
import com.base.core.ui.recyclerview.DisplayItem
import com.base.data.response.MusicListResponse
import com.base.searchapp.ui.base.viewmodel.BaseFragmentViewModel
import com.base.searchapp.ui.pages.music.repository.MusicFragmentRepository
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

/**
 *   Created by Emre UYGUN on 12/5/20
 */

@FragmentScope
class MusicFragmentViewModel @Inject constructor(
    private val repository: MusicFragmentRepository
) : BaseFragmentViewModel() {

    val musicList = mutableListOf<DisplayItem>()
    val musicListPublishSubject = PublishSubject.create<List<DisplayItem>>()

    var musicListDataResult: LiveData<DataFetchResult<MusicListResponse>> =
        Transformations.map(repository.musicListDataResult.toLiveData(disposables)) {
            when (it) {
                is DataFetchResult.Progress -> {
                }
                is DataFetchResult.Failure -> {
                }
                is DataFetchResult.Success -> {
                    consumeMusicList(it.data)
                }
            }
            it
        }

    private fun consumeMusicList(response: MusicListResponse) {
        val list = arrayListOf<MusicDTO>()
        response.results.map { _results ->
            list.add(
                MusicDTO(
                    list = _results
                )
            )
        }


        musicList.add(GridRecyclerDTO(list = list))
        musicListPublishSubject.onNext(musicList)
    }

    fun getMusicList(term: String?) {
        repository.getMusicList(term)
    }

}