package com.example.firstapicall.ui.main

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstapicall.data.Repository
import kotlinx.coroutines.launch

enum class ApiStatus {LOADING, DONE, ERROR}

class MainViewModel : ViewModel() {

    private val _loading = MutableLiveData<ApiStatus>()
    val loading: LiveData<ApiStatus>
        get() = _loading

    private val repository = Repository()

    val songs = repository.songs

    fun search(term: String){
        // hier müssen wir eine Coroutine launchen, weil loadSongs (und das darin aufgerufene getResponse) beides suspend-functions sind,
        viewModelScope.launch {
            try {
                _loading.value = ApiStatus.LOADING
                repository.loadSongs(term)
                _loading.value = ApiStatus.DONE
            } catch (e: Exception){
                Log.e(TAG, "Error loading songs: $e")
                _loading.value = ApiStatus.ERROR
            }

        }

    }
}