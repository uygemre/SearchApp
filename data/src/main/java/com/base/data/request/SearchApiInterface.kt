package com.base.data.request

import com.base.data.response.BookListResponse
import com.base.data.response.MovieListResponse
import com.base.data.response.MusicListResponse
import com.base.data.response.SoftwareListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApiInterface {

    @GET("https://itunes.apple.com/search?")
    fun getMusicList(
        @Query("term") term: String?,
        @Query("media") media: String = "music",
        @Query("limit") limit: Int = 20
    ): Single<MusicListResponse>

    @GET("https://itunes.apple.com/search?")
    fun getMovieList(
        @Query("term") term: String?,
        @Query("media") media: String = "movie"
    ): Single<MovieListResponse>

    @GET("https://itunes.apple.com/search?")
    fun getSoftwareList(
        @Query("term") term: String?,
        @Query("media") media: String = "software"
    ): Single<SoftwareListResponse>

    @GET("https://itunes.apple.com/search?")
    fun getBookList(
        @Query("term") term: String?,
        @Query("media") media: String = "ebook"
    ): Single<BookListResponse>

}