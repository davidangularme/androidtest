package com.example.david

private val Any.items: List<YoutubeVideo>?
    get() {
        return null
    }
private val Any.isSuccessful: Boolean
    get() {
        TODO("Not yet implemented")
    }

class YoutubeRepository(private val youtubeApi: YoutubeApi) {
    suspend fun searchVideos(apiKey: String, query: String): List<YoutubeVideo>? {
        val response = youtubeApi.searchVideos(apiKey, query)
        if (response.isSuccessful) {
            return response.body()?.items
        }
        return null
    }
}

private fun Any.body(): Any {
    TODO("Not yet implemented")
}
