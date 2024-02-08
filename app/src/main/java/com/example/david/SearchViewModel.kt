package com.example.david

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SearchViewModel(private val repository: YoutubeRepository) : ViewModel() {
    private val _videos = MutableLiveData<List<YoutubeVideo>?>()
    val videos: MutableLiveData<List<YoutubeVideo>?> = _videos

    suspend fun searchVideos(apiKey: String, query: String) {
        viewModelScope.launch {
            val result = repository.searchVideos(apiKey, query)
            _videos.postValue(result)
        }
    }
}
