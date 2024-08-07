package com.example.android3homework8mc5.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3homework8mc5.data.remote.models.Articles
import com.example.android3homework8mc5.data.repositories.NewRepository
import com.example.android3homework8mc5.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewRepository,
) : ViewModel() {
    private val _newsLiveData = MutableLiveData<UiState<List<Articles>>>()
    val newsLiveData: LiveData<UiState<List<Articles>>> = _newsLiveData

    init {
        searchNew("")
    }

    fun searchNew(query: String) {
        newsRepository.getNews(query = query,
            onResponse = { data ->
                _newsLiveData.value = UiState(isLoading = false, success = data)
                Log.e("tage", "onResponse:${data}")
            },
            onFailure = { t ->
                _newsLiveData.value = UiState(
                    isLoading = false, error = null
                )
                Log.e("tage", "searchNew:${t} ")
            })
    }
}