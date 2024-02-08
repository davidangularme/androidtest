package com.example.david

data class YoutubeSearchResponse(
    val items: List<YoutubeVideo>
)

data class YoutubeVideo(
    val id: String,
    val snippet: VideoSnippet
)

data class VideoSnippet(
    val title: String,
    val thumbnails: Map<String, Thumbnail>
)

data class Thumbnail(
    val url: String,
    val width: Int,
    val height: Int
)
