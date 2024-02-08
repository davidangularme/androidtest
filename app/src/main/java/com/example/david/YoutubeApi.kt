package com.example.david
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response

interface YoutubeApi {
    @GET("/youtube/v3/search")
    suspend fun searchVideos(
        @Query("key") apiKey: String,
        @Query("part") part: String = "snippet",
        @Query("q") query: String,
        @Query("type") type: String = "video",
        @Query("maxResults") maxResults: Int = 20
    ): Response<YoutubeSearchResponse>

    abstract fun searchVideos(apiKey: String, part: String): Any
}
