package com.yoonlab.youtubeclone

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

private val apiKey : String = "Api Key"
interface YouTubeDataSearch {
    @GET ("youtube/v3/search?")
    fun getSearchResult(@Query ("part") part: String,
    @Query("q") q : String,
    @Query("key") key: String = apiKey): Call<YouTubeSearch>
}